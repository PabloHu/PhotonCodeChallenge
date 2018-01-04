package mobile.huaman.photoncodechallenge;

import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Pablo on 1/4/2018.
 */

public class PresenterTest {

    @Test
    public  void sample1(){
        assertThat(PresenterTest.("name@email.com"), is(true));
    }
}
