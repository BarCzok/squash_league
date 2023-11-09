package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.ScoreForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;

public class ScoreControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ensureThatUserIsNotAllowedToSubmitGameResultsWhereSetCountIsDifferentThan5(){
        ScoreController scoreController = new ScoreController();

        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setPoints1(1);
        scoreForm.setPoints2(1);

        String view = scoreController.addScore(scoreForm, new ModelMap());

        assertEquals("scores/addScore", view);
    }

    @Test
    public void ensureThatUserIsNotAllowedToSubmitGameResultsWhereSetNumbersAreNegative(){
        ScoreController scoreController = new ScoreController();

        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setPoints1(-1);
        scoreForm.setPoints2(6);

        String view = scoreController.addScore(scoreForm, new ModelMap());

        assertEquals("scores/addScore", view);
    }
}