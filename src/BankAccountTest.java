import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        assertEquals(0, account.getAmount());
        assertEquals("KZT", account.getCurrency());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccount account = new BankAccount("a", "b");

        account.block();

        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        String firstName = "a";
        String secondName = "b";
        String[] expectedFullName = {firstName, secondName};
        BankAccount account = new BankAccount(firstName, secondName);

        String[] fullName = account.getFullName();

        assertArrayEquals(expectedFullName, fullName);

    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        BankAccount account = new BankAccount("a", "b");
        IllegalStateException thrown = assertThrows(IllegalStateException.class, account::getAmount);

        assertEquals("Счёт не активирован.", thrown.getMessage());
        assertNull(account.getCurrency());
    }
}