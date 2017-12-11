package com.revature.app;

import static org.junit.Assert.*;
import org.junit.Test;
import com.revature.account.*;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public final void accountDoesNotExist(){
        BankAccount a = App.getAccount("lalalalala", "tfslfnlsfn");
        assertEquals(null, a);
    }

  
}
