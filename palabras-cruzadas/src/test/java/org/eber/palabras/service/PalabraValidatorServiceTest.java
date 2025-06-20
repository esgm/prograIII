package org.eber.palabras.service;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalabraValidatorServiceTest {

    @Test
    public void testValidBoard() {
        char[][] board = {
                {'H','E','L','L','O','#','W','O','R','D'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'J','A','V','A','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'C','O','D','E','#','C','A','T','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','#','P','Y','T','H','O','N','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };

        String[] diccionario = {"HELLO", "WORLD", "JAVA", "CODE", "CAT", "PYTHON"};

        PalabraValidatorService service = new PalabraValidatorService();
        assertTrue(service.validar(board, diccionario));
    }

    @Test
    public void testInvalidBoard() {
        char[][] board = {
                {'H','E','L','L','O','#','W','O','R','D'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'J','A','V','A','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'C','O','D','E','#','X','X','X','#','#'}, // CAT inválido
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','#','P','Y','T','H','O','N','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };

        String[] diccionario = {"HELLO", "WORLD", "JAVA", "CODE", "CAT", "PYTHON"};

        PalabraValidatorService service = new PalabraValidatorService();
        assertFalse(service.validar(board, diccionario));
    }
}
