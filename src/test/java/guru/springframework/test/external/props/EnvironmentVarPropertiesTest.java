package guru.springframework.test.external.props;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.test.jms.FakeJmsBroker;
import guru.test.config.external.props.ExternalPropsEnvironmentConfiguration;
import guru.test.config.external.props.ExternalPropsPropertySourceTestConfig;

/**
 * Test loading FakeJmsBroker bean given ExternalPropsEnvironmentConfiguration.
 * Created by jt on 5/7/16.
 * Update kxenson on 09/11/21
 */
@RunWith(SpringJUnit4ClassRunner.class) // load Spring Context
@ContextConfiguration(classes = ExternalPropsEnvironmentConfiguration.class)
public class EnvironmentVarPropertiesTest {

    @Autowired
    FakeJmsBroker fakeJmsBroker;

    @Test
    public void testPropsSet() {
        assertEquals("10.10.10.123", fakeJmsBroker.getUrl());
        assertEquals(3330, fakeJmsBroker.getPort().intValue());
        assertEquals("Ron", fakeJmsBroker.getUser());
        assertEquals("Burgundy", fakeJmsBroker.getPassword());
    }
}