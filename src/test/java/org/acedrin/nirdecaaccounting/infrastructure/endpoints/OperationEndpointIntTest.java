package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.usecase.CreateOperation;
import org.acedrin.nirdecaaccounting.usecase.GetAllOperations;
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
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OperationEndpoint.class)
public class OperationEndpointIntTest {

    private static final Long TRANSACTION_ID = 0L;
    private static final Long USER_ID = 1L;
    private static final Long CATEGORY_ID = 2L;
    private static final Long TAG_ID = 3L;
    private static final String DATE = "10/10/2015";
    private static final Integer AMOUNT = 100;
    private static final String DESCRIPTION = "Operation description";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateOperation createOperation;

    @MockBean
    private GetAllOperations getAllOperations;

    private Operation operation;

    @Before
    public void setUp() throws Exception {
        operation = new Operation(USER_ID, CATEGORY_ID, TAG_ID, LocalDate.parse(DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy")), AMOUNT, DESCRIPTION);
        operation.setId(TRANSACTION_ID);
    }

    @Test
    public void post_onOperationEndpoint_shouldReturnCreatedOperation_asJson() throws Exception {
        // Given
        when(createOperation.create(any(Operation.class))).thenReturn(operation);

        // When
        ResultActions resultActions = mockMvc.perform(post("/api/operations")
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

    @Test
    public void get_onOperationsEndpoint_shouldReturnAllOperations() throws Exception {
        // Given
        List<Operation> operationList = asList(operation, new Operation());
        when(getAllOperations.findAllOperations()).thenReturn(operationList);

        // When
        ResultActions resultActions = mockMvc.perform(get("/api/operations"));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(content().string("[" +
                        "{\"id\":" + TRANSACTION_ID + "," +
                        "\"userId\":" + USER_ID + "," +
                        "\"categoryId\":" + CATEGORY_ID + "," +
                        "\"tagId\":" + TAG_ID + "," +
                        "\"date\":\"" + DATE + "\"," +
                        "\"amount\":" + AMOUNT + "," +
                        "\"description\":\"" + DESCRIPTION + "\"}," +
                        "{\"id\":null," +
                        "\"userId\":null," +
                        "\"categoryId\":null," +
                        "\"tagId\":null," +
                        "\"date\":null," +
                        "\"amount\":null," +
                        "\"description\":null}" +
                        "]"));
    }
}