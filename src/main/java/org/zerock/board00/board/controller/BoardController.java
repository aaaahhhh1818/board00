package org.zerock.board00.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board00.board.service.BoardDTO;
import org.zerock.board00.board.service.BoardService;
import org.zerock.board00.board.service.TimeService;

@Controller
@RequestMapping("/board/*")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final TimeService timeService;

    @GetMapping("/time")
    public void getTime(Model model) {

        log.info("============controller getTime=============");
        model.addAttribute("time", timeService.getNow());
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO){

        log.info("boardDTOM           " + boardDTO);

        Long bno = boardService.register(boardDTO);

        return "redirect:/board/list";
    }

}
