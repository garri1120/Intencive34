package ru.aston.popov_am.task4.DAOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.popov_am.task4.DAO.JoinedQueriesImpl;


import static javax.swing.text.html.parser.DTDConstants.ID;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class JoinedQueriesImplTest {
    JoinedQueriesImpl joinedQueries = Mockito.mock(JoinedQueriesImpl.class);
    @Test
    public void sumOfUserOrdersById() {
        when(joinedQueries.sumOfUserOrdersById(anyInt())).thenReturn(anyInt());
        Assertions.assertEquals(joinedQueries.sumOfUserOrdersById(ID),anyInt());

    }
}
