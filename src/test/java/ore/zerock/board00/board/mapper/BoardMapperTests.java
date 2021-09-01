package ore.zerock.board00.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.board00.board.config.BoardRootConfig;
import org.zerock.board00.board.domain.Board;
import org.zerock.board00.board.mapper.BoardMapper;
import org.zerock.board00.common.config.RootConfig;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BoardRootConfig.class, RootConfig.class})
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void testDummies(){

        IntStream.rangeClosed(1,100).forEach(i -> {
            Board board = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer("user" + (i % 10))
                    .build();

            boardMapper.insert(board);
        });
    }

    @Test
    public void testDummies2(){

            Board board = Board.builder()
                    .title("ABC")
                    .content("ABC")
                    .writer("user11")
                    .build();

            boardMapper.insert(board);
    }
}
