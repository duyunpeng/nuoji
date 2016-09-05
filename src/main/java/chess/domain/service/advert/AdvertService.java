package chess.domain.service.advert;

import chess.core.enums.AdvertType;
import chess.core.exception.NoFoundException;
import chess.core.mapping.IMappingService;
import chess.core.upload.IFileUploadService;
import chess.domain.model.advert.Advert;
import chess.domain.model.advert.IAdvertRepository;
import chess.domain.service.advert.command.CreateAdvertCommand;
import chess.domain.service.advert.command.EditAdvertCommand;
import chess.domain.service.advert.command.ListAdvertCommand;
import chess.domain.service.advert.representation.AdvertRepresentation;
import chess.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dyp on 2016/8/3.
 */
@Service("advertService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AdvertService implements IAdvertService {

    @Autowired
    protected IFileUploadService fileUploadService;
    @Autowired
    private IAdvertRepository<Advert, String> advertRepository;

    @Autowired
    private IMappingService mappingService;

    @Override
    public AdvertRepresentation searchByID(String id) {
        Advert advert = advertRepository.getById(id);
        if (null == advert) {
            throw new NoFoundException("没有找到ID[" + id + "]的advert数据");
        }
        return mappingService.map(advert, AdvertRepresentation.class, false);
    }

    @Override
    public AdvertRepresentation searchByUrl(String url) {
        Advert advert = advertRepository.searchByUrl(url);
        return mappingService.map(advert, AdvertRepresentation.class, false);
    }

    @Override
    public Pagination<AdvertRepresentation> pagination(ListAdvertCommand command) {
        command.verifyPage();
        command.verifyPageSize(30);
        List<Criterion> criterionList = new ArrayList<>();
        if (null != command.getType() && command.getType() != AdvertType.ALL) {
            criterionList.add(Restrictions.eq("type", command.getType()));
        }
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("createDate"));

        Pagination<Advert> pagination = advertRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
        List<AdvertRepresentation> data = mappingService.mapAsList(pagination.getData(), AdvertRepresentation.class);
        return new Pagination<>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }


    @Override
    public AdvertRepresentation create(CreateAdvertCommand command) {
        Advert advert = new Advert(command.getType(), command.getContent(), command.getUrl());
        fileUploadService.moveToImg(command.getUrl());
        advertRepository.save(advert);
        return mappingService.map(advert, AdvertRepresentation.class, false);
    }

    @Override
    public Advert edit(EditAdvertCommand command) {
        Advert advert = advertRepository.getById(command.getId());
        advert.changeContent(command.getContent());
        advert.changeType(command.getType());
        advert.changeUrl(command.getUrl());
        fileUploadService.moveToImg(command.getUrl());
        if (command.getUrl().equals(advert.getUrl())) {
            fileUploadService.deleteImg(command.getUrl());
        }
        advertRepository.update(advert);
        return advert;
    }

    @Override
    public void delete(String id) {
        Advert advert = advertRepository.getById(id);
        advertRepository.delete(advert);
    }

}
