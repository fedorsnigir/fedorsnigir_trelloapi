import api.BoardApi;
import beans.Board;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static enums.ColorsEnum.RED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBoardApi {
    private String id;
    private String name;
    private String description;
    private String newName = RandomStringUtils.randomAlphanumeric(10);
    private String newDescription = RandomStringUtils.randomAlphanumeric(10);
    private String newColor = RED.value;
    private Board board;

    @BeforeMethod
    public void prepareBoard() {
        board = BoardApi.with().createBoard();
        id = board.id;
        name = board.name;
        description = board.desc;
    }

    @AfterMethod
    public void removeBoard() {
        BoardApi.with().removeBoard(id);

        BoardApi.with()
                .getResponse(id)
                .then()
                .specification(BoardApi.notFoundResponseSpecification());
    }

    @Test
    public void checkBoardCreated() {
        assertThat(board.closed, is(false));
        assertThat(board.id, is(id));
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

    @Test
    public void checkBoardClosed() {
        board = BoardApi.with()
                .setClosed(true)
                .editBoard(id);

        assertThat(board.closed, is(true));
    }
}