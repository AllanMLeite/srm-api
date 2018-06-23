package com.srm.api.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\cucumber\\IncluirMetrica.feature",  strict = true)
public class IncluirMetricaTest {

}
