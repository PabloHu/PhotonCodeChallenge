package mobile.huaman.photoncodechallenge;

import org.junit.Before;
import org.junit.Test;

import mobile.huaman.photoncodechallenge.photoncodechallengeactivity.PhotonCodeChallengeActivity;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Pablo on 12/20/2017.
 */

public class PhotonCodeChallengeActivityTest {

    private PhotonCodeChallengeActivity photonCodeChallengeActivity;
    //private Addition addition;

    @Before
    public void setup(){
       // addition = mock(Addition.class);
        photonCodeChallengeActivity = new PhotonCodeChallengeActivity(addition);
        photonCodeChallengeActivity.setVal1(10);
        photonCodeChallengeActivity.setVal1(5);

    }
    @Test
    public void should_susbtract_the_input_numbers(){
        assertEquals(photonCodeChallengeActivity.susbtraction(), 4);
    }
}
