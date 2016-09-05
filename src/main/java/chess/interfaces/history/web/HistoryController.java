package chess.interfaces.history.web;

import chess.core.exception.NoFoundException;
import chess.domain.model.account.Account;
import chess.domain.model.history.History;
import chess.domain.service.account.command.EditAccountCommand;
import chess.domain.service.history.IHistoryService;
import chess.domain.service.history.command.EditHistoryCommand;
import chess.domain.service.history.command.ListHistoryCommand;
import chess.domain.service.history.representation.HistoryRepresentation;
import chess.infrastructure.persistence.hibernate.generic.Pagination;
import chess.interfaces.shared.web.AlertMessage;
import chess.interfaces.shared.web.BaseController;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jm on 2016/8/3.
 */
@Controller
@RequestMapping("/history")
public class HistoryController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IHistoryService historyService;

    @RequestMapping(value = "/pagination")
    public ModelAndView pagination(ListHistoryCommand command) {
        return new ModelAndView("/history/list", "pagination", historyService.paginationAdmin(command)).addObject("command", command);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Pagination<HistoryRepresentation> list(@RequestBody ListHistoryCommand command) {
        return historyService.pagination(command);
    }

    @RequestMapping(value = "/new_history")
    @ResponseBody
    public History getNewHistory() {
        return historyService.newHistory();
    }

    @RequestMapping(value = "/info/{id}")
    public ModelAndView info(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws NotFoundException {
        AlertMessage alertMessage;
        History history;
        try {
            history = historyService.searchByID(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/history/info", "history", history);
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable String id, @ModelAttribute("command") EditHistoryCommand command,
                             RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        History history;
        try {
            history = historyService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("history.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/history/pagination");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/history/edit", "history", history).addObject("command", command);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("command") EditHistoryCommand command,
                             RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        History history;
        try {
            history = historyService.edit(command);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        logger.info("修改history[" + history.getHistoryNo() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", command.getId());
        return new ModelAndView("redirect:/history/info/{id}");

    }
}
