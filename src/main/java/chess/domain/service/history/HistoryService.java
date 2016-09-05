package chess.domain.service.history;

import chess.core.common.id.IdFactory;
import chess.core.enums.YesOrNoStatus;
import chess.core.exception.NoFoundException;
import chess.core.mapping.IMappingService;
import chess.core.util.CoreDateUtils;
import chess.core.util.CoreStringUtils;
import chess.domain.model.history.History;
import chess.domain.model.history.IHistoryRepository;
import chess.domain.service.history.command.EditHistoryCommand;
import chess.domain.service.history.command.ListHistoryCommand;
import chess.domain.service.history.representation.HistoryRepresentation;
import chess.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yjh on 2016/8/3.
 */
@Service("historyService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class HistoryService implements IHistoryService {

    @Autowired
    private IHistoryRepository<History, String> historyRepository;

    @Autowired
    private IdFactory idFactory;

    @Autowired
    private IMappingService mappingService;

    @Override
    public void initCreate() {
        if (null == getThisDay() || !CoreDateUtils.isSameDay(getThisDay().getCreateDate(), new Date())) {
            //每天固定开288期  每5分钟一期
            for (int i = 0; i < 1440; i += 5) {
                String[] number = new String[3];
                number[0] = String.valueOf((int) (Math.random() * (10)));
                number[1] = String.valueOf((int) (Math.random() * (10)));
                number[2] = String.valueOf((int) (Math.random() * (10)));
                String no = number[0] + "," + number[1] + "," + number[2];
                String date = CoreDateUtils.formatDate(new Date(), "yyyy-MM-dd ") + CoreDateUtils.minConvertDateTime(i);

                YesOrNoStatus isOpen = CoreDateUtils.parseDate(date, "yyyy-MM-dd HH:mm").before(new Date()) ? YesOrNoStatus.YES : YesOrNoStatus.NO;
                History history = new History(idFactory.getNextId(), no, CoreDateUtils.parseDate(date, "yyyy-MM-dd HH:mm"), isOpen);
                historyRepository.save(history);
            }
        } else {
            List<Criterion> criterionList = new ArrayList<>();
            Date startDate = new Date();
            startDate.setHours(0);
            startDate.setMinutes(0);
            startDate.setSeconds(0);
            Date endDate = new Date();
            endDate.setHours(23);
            endDate.setMinutes(59);
            endDate.setSeconds(59);
            criterionList.add(Restrictions.between("lotteryDate", startDate, endDate));

            List<History> historyList = historyRepository.list(criterionList, null);
            historyList.stream().filter(history -> history.getLotteryDate().before(new Date())).forEach(history -> {
                history.setIsOpen(YesOrNoStatus.YES);
                historyRepository.update(history);
            });
            System.out.println("今天的已经创建");
        }
    }

    @Override
    public History getThisDay() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("createDate"));
        List<History> histories = historyRepository.list(null, orderList);
        return histories.size() > 0 ? histories.get(0) : null;
    }

    @Override
    public void openLottery() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("isOpen", YesOrNoStatus.NO));
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.asc("lotteryDate"));
        List<History> historyList = historyRepository.list(criterionList, orderList);
        if (historyList.size() > 0) {
            History history = historyList.get(0);
            Date date = new Date();
            if (date.getMinutes() == history.getLotteryDate().getMinutes()) {
                System.out.println(history.getHistoryNo() + "期开奖了");
                history.setIsOpen(YesOrNoStatus.YES);
                historyRepository.update(history);
            }
        }
    }

    @Override
    public Pagination<HistoryRepresentation> pagination(ListHistoryCommand command) {
        command.verifyPage();
        command.verifyPageSize(30);
        List<Criterion> criterionList = new ArrayList<>();

        criterionList.add(Restrictions.eq("isOpen", YesOrNoStatus.YES));
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("lotteryDate"));

        Pagination<History> pagination = historyRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
        List<HistoryRepresentation> data = mappingService.mapAsList(pagination.getData(), HistoryRepresentation.class);
        return new Pagination<>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    public Pagination<HistoryRepresentation> paginationAdmin(ListHistoryCommand command) {
        command.verifyPage();
        command.verifyPageSize(30);
        List<Criterion> criterionList = new ArrayList<>();
        if (!CoreStringUtils.isEmpty(command.getHistoryNo())) {
            criterionList.add(Restrictions.like("historyNo", command.getHistoryNo(), MatchMode.ANYWHERE));
        }
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("lotteryDate"));

        Pagination<History> pagination = historyRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
        List<HistoryRepresentation> data = mappingService.mapAsList(pagination.getData(), HistoryRepresentation.class);
        return new Pagination<>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    public History searchByID(String id) {
        History history = historyRepository.getById(id);
        if (null == history) {
            throw new NoFoundException("没有找到ID[" + id + "]的Account数据");
        }
        return history;
    }

    @Override
    public History edit(EditHistoryCommand command) {
        History history = this.searchByID(command.getId());
        history.changeLotteryNo(command.getLotteryNo());
        historyRepository.update(history);
        return history;
    }

    @Override
    public History newHistory() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("isOpen", YesOrNoStatus.YES));
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("lotteryDate"));
        return historyRepository.list(criterionList, orderList).get(0);
    }
}
