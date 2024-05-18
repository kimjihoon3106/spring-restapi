package springrestAPI.springrestAPI.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrestAPI.springrestAPI.board.dto.request.BoardCreateRequest;
import springrestAPI.springrestAPI.board.dto.request.BoardUpdateRequest;
import springrestAPI.springrestAPI.board.dto.response.BoardCreateResponse;
import springrestAPI.springrestAPI.board.dto.response.BoardGetResponse;
import springrestAPI.springrestAPI.board.dto.response.BoardInfoResponse;
import springrestAPI.springrestAPI.board.dto.response.BoardUpdateResponse;
import springrestAPI.springrestAPI.board.service.BoardService;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    // 게시물 작성
    @PostMapping("/write")
    public ResponseEntity<BoardCreateResponse> writeBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        return new ResponseEntity<>(boardService.boardCreate(boardCreateRequest), HttpStatus.CREATED);
    }

    // 게시물 모두 가져오기
    @GetMapping
    public ResponseEntity<List<BoardGetResponse>> getBoards() {
        return new ResponseEntity<>(boardService.boardGets(), HttpStatus.OK);
    }

    // 게시물 상세 보기
    @GetMapping("/detail/{id}")
    public ResponseEntity<BoardInfoResponse> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.boardGet(id),HttpStatus.OK);
    }


    //게시물 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id") Long id) {
        boardService.boardDelete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //게시물 수정
    @PutMapping("/modify/{id}")
    public ResponseEntity<BoardUpdateResponse> updateBoard(@PathVariable("id") Long id , @RequestBody BoardUpdateRequest boardUpdateRequest) {
        boardService.boardUpdate(boardUpdateRequest, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
