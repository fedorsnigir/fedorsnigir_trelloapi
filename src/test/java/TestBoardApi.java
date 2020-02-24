import api.BoardApi;
import beans.Board;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class TestBoardApi {
    private String id;
    private String name = "test board";
    private String description = "test description";
    private String newName = "new test board";
    private String newDescription = "new test description";
    private String newColor = "red";
    private Board board;

    @BeforeTest
    public void prepareBoard() {
        board = BoardApi.with()
                .setDescription(description)
                .createBoard(name);
        id = board.id;
    }

    @Test
    public void checkBoardCreated() {
        assertThat(board.closed, is(false));
        assertThat(board.name, is(name));
        assertThat(board.desc, is(description));
    }

    @Test
    public void checkBoardEdited() {
        board = BoardApi.with()
                .setName(newName)
                .setDescription(newDescription)
                .editBoard(id);

        assertThat(board.name, is(newName));
        assertThat(board.desc, is(newDescription));
    }

    @Test
    public void checkBoardColor() {
        board = BoardApi.with()
                .setColor(newColor)
                .editBoard(id);

        assertThat(board.prefs.background, is(newColor));
    }

    @Test (priority = 4)
    public void checkBoardClosed() {
        board = BoardApi.with()
                .setClosed(true)
                .editBoard(id);

        assertThat(board.closed, is(true));
    }

    @Test (priority = 5)
    public void checkBoardRemoved() {
        board = BoardApi.with()
                .removeBoard(id);

        assertThat(board.id, nullValue());
    }
}
