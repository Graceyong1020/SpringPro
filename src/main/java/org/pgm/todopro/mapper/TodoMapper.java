package org.pgm.todopro.mapper;

import org.pgm.todopro.dto.PageRequestDTO;
import org.pgm.todopro.dto.TodoDTO;
import org.pgm.todopro.vo.TodoVO;

import java.util.List;

public interface TodoMapper { //TodoMapper 인터페이스에 메서드를 선언
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> getList();
    TodoVO selectOne(int tno);
    void delete(Long tno);
    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

}
