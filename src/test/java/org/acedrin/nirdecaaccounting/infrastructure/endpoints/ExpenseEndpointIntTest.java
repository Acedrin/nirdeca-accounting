package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.usecase.CreateExpense;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseEndpoint.class)
public class ExpenseEndpointIntTest {

    private static final Long TRANSACTION_ID = 0L;
    private static final Long USER_ID = 1L;
    private static final Long CATEGORY_ID = 2L;
    private static final Long TAG_ID = 3L;
    private static final String DATE = "10/10/2015";
    private static final Integer AMOUNT = 100;
    private static final String DESCRIPTION = "Expense description";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateExpense createExpense;

    private Expense expense;

    @Before
    public void setUp() throws Exception {
        expense = new Expense(USER_ID, CATEGORY_ID, TAG_ID, LocalDate.parse(DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy")), AMOUNT, DESCRIPTION);
        expense.setId(TRANSACTION_ID);
    }

    @Test
    public void post_onExpenseEndpoint_shouldReturnCreatedExpense_asJson() throws Exception {
        // Given
        when(createExpense.create(any(Expense.class))).thenReturn(expense);

        // When
        ResultActions resultActions = mockMvc.perform(post("/api/expenses")
                .contentType(APPLICATION_JSON)
                .content("{\"userId\":\"" + USER_ID + "\"," +
                        "\"categoryId\":\"" + CATEGORY_ID + "\"," +
                        "\"tagId\":\"" + TAG_ID + "\"," +
                        "\"date\":\"" + DATE + "\"," +
                        "\"amount\":\"" + AMOUNT + "\"," +
                        "\"description\":\"" + DESCRIPTION + "\"}"));

        // Then
        resultActions.andExpect(status().isCreated())
                .andExpect(content().string("{\"id\":" + TRANSACTION_ID + "," +
                        "\"userId\":" + USER_ID + "," +
                        "\"categoryId\":" + CATEGORY_ID + "," +
                        "\"tagId\":" + TAG_ID + "," +
                        "\"date\":\"" + DATE + "\"," +
                        "\"amount\":" + AMOUNT + "," +
                        "\"description\":\"" + DESCRIPTION + "\"}"));
    }
}