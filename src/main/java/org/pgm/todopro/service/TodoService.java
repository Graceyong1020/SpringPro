package org.pgm.todopro.service;

import org.pgm.todopro.dto.PageRequestDTO;
import org.pgm.todopro.dto.PageResponseDTO;
import org.pgm.todopro.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

    //List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO); //PageRequestDTO를 이용하여 페이징 처리, reponseDTO를 이용하여 결과를 전달

    List<TodoDTO> getAll();

    TodoDTO getOne(int tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);

}
