package com.baeldung.captcha;

import org.junit.Test;
import org.junit.Assert;

public class GoogleResponseGetActionTest {

    @Test
    public void testGetActionWithValidValue() {
        // Arrange
        GoogleResponse googleResponse = new GoogleResponse();
        String action = "validAction";
        googleResponse.setAction(action);

        // Act
        String actualAction = googleResponse.getAction();

        // Assert
        Assert.assertEquals(action, actualAction);
    }

    @Test
    public void testGetActionWithNullValue() {
        // Arrange
        GoogleResponse googleResponse = new GoogleResponse();

        // Act
        String actualAction = googleResponse.getAction();

        // Assert
        Assert.assertNull(actualAction);
    }

    @Test
    public void testGetActionWithEmptyValue() {
        // Arrange
        GoogleResponse googleResponse = new GoogleResponse();
        String action = "";
        googleResponse.setAction(action);

        // Act
        String actualAction = googleResponse.getAction();

        // Assert
        Assert.assertEquals(action, actualAction);
    }
}
