package springrestAPI.springrestAPI.board.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardUpdateRequest {
    private Long id;
    private String name;
    private String about;
}
