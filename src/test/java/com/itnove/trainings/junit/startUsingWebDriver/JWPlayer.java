package com.itnove.trainings.junit.startUsingWebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by guillemhernandezsola on 09/05/2017.
 */
public class JWPlayer extends BaseTest {
    //Clase adaptada a JWPlayer 7
    /**
     * JavaScript executor to fire the jwplayer methods
     */
    protected JavascriptExecutor executor;
    protected WebDriver driver;

    /**
     * Constructor.
     *
     * @param driver WebDriver Element to use as executor for the JS functions
     */
    public JWPlayer(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
    }

    /**
     * Wait for the jwplayer to load on the page.<br> Timeout: 30 seconds<br>Polls every 5 seconds
     *
     * @throws InterruptedException
     */
    protected void waitForPlayer(WebDriver driver) throws InterruptedException {
        wait.pause(2000);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (executor.executeScript("return jwplayer().getState()") != null);
            }
        });
    }

    public boolean assertStateRetornarDirecto() throws InterruptedException {
        waitForPlayer(driver);
        double pos = 0;
        String strPos = "";
        boolean avanza = false;
        String estado = String.valueOf(executor.executeScript("return jwplayer().getState()"));
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        pos = Double.parseDouble(strPos);
        System.out.println(estado);
        System.out.println(pos);
        while (pos < -50.0) {
            strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
            pos = Double.parseDouble(strPos);
            estado = String.valueOf(executor.executeScript("return jwplayer().getState()"));
            System.out.println(estado);
            System.out.println(pos);
        }
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        pos = Double.parseDouble(strPos);
        if (pos > -50.0) avanza = true;
        System.out.println(estado);
        System.out.println(pos);
        return avanza;
    }

    public boolean rewind(int seconds) throws InterruptedException {
        waitForPlayer(driver);
        double initialPosition = 0;
        double finalPos = 0;
        String strPos = "";
        String estado = "";
        boolean rewind = false;
        estado = String.valueOf(executor.executeScript("return jwplayer().getState()"));
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        initialPosition = Double.parseDouble(strPos);
        int seek = (int) initialPosition - seconds;
        System.out.println("rewind" + Integer.toString(seconds) + " - " + estado);
        System.out.println("rewind initialPosition" + Integer.toString(seconds) + " - " + initialPosition);
        System.out.println("jwplayer().seek(jwplayer().getPosition() - " + Integer.toString(seconds) + ")");
        executor.executeScript("jwplayer().seek(" + Integer.toString(seek) + ")");
        estado = String.valueOf(executor.executeScript("return jwplayer().getState()"));
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        initialPosition = Double.parseDouble(strPos);
        System.out.println("assertStateRewind" + Integer.toString(seconds) + " - " + estado);
        System.out.println("assertStateRewind currentPosition" + Integer.toString(seconds) + " - " + initialPosition);
        while (initialPosition < finalPos) {
            System.out.println("Ejecutando script rewind");
            System.out.println("jwplayer().seek(" + Integer.toString(seek) + ")");
            executor.executeScript("jwplayer().seek(" + Integer.toString(seek) + ")");
            strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
            finalPos = Double.parseDouble(strPos);
            System.out.println("rewind" + Integer.toString(seconds) + " - " + estado);
            System.out.println("rewind initialPosition" + Integer.toString(seconds) + " - " + initialPosition);
            System.out.println("rewind currentPosition" + Integer.toString(seconds) + " - " + finalPos);
        }
        if (initialPosition >= finalPos) rewind = true;
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        System.out.println("rewind to position " + strPos);
        return rewind;
    }

    public boolean fastForward(int seconds) throws InterruptedException {
        waitForPlayer(driver);
        double initialPosition = 0;
        double finalPos = 0;
        String strPos = "";
        String estado = "";
        boolean avanza = false;
        estado = String.valueOf(executor.executeScript("return jwplayer().getState()"));
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        initialPosition = Double.parseDouble(strPos);
        System.out.println("fastForward" + Integer.toString(seconds) + " - " + estado);
        System.out.println("fastForward initialPosition" + Integer.toString(seconds) + " - " + initialPosition);
        System.out.println("jwplayer().seek(" + Integer.toString(seconds) + ")");
        executor.executeScript("jwplayer().seek(" + Integer.toString(seconds) + ")");
        estado = String.valueOf(executor.executeScript("return jwplayer().getState()"));
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        initialPosition = Double.parseDouble(strPos);
        System.out.println("fastForward" + Integer.toString(seconds) + " - " + estado);
        System.out.println("fastForward currentPosition" + Integer.toString(seconds) + " - " + initialPosition);
        while (finalPos < seconds) {
            System.out.println("Ejecutando script rewind");
            System.out.println("jwplayer().seek(" + Integer.toString(seconds) + ")");
            executor.executeScript("jwplayer().seek(" + Integer.toString(seconds) + ")");
            strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
            finalPos = Double.parseDouble(strPos);
            System.out.println("fastForward" + Integer.toString(seconds) + " - " + estado);
            System.out.println("fastForward currentPosition" + Integer.toString(seconds) + " - " + initialPosition);
            System.out.println("fastForward finalPos" + Integer.toString(seconds) + " - " + finalPos);
        }
        if (finalPos >= seconds) avanza = true;
        strPos = String.valueOf(executor.executeScript("return jwplayer().getPosition()"));
        System.out.println("fastForward to position " + strPos);
        return avanza;
    }

    /**
     * Asserts the state of the player is buffering or playing.
     *
     * @return <code>TRUE</code> if the current state of the player matches the expected one.<br>
     * <code>FALSE</code> if the current state of the player does not match the expected one.
     * @throws InterruptedException
     */
    public boolean assertStatePlaying() throws InterruptedException {
        waitForPlayer(driver);
        return executor.executeScript("return jwplayer().getState()").equals("buffering") ||
                executor.executeScript("return jwplayer().getState()").equals("playing");
    }

    public boolean assertStatePlay() throws InterruptedException {
        waitForPlayer(driver);
        executor.executeScript("jwplayer().play(true)");
        System.out.println(executor.executeScript("return jwplayer().getState()"));
        return executor.executeScript("return jwplayer().getState()").equals("buffering") ||
                executor.executeScript("return jwplayer().getState()").equals("playing");
    }

    public boolean assertStateMuteTrue() throws InterruptedException {
        waitForPlayer(driver);
        executor.executeScript("jwplayer().setMute(true)");
        System.out.println(executor.executeScript("return jwplayer().getMute()"));
        return executor.executeScript("return jwplayer().getMute()").equals(true);
    }

    public boolean assertVolume(double volume) throws InterruptedException {
        waitForPlayer(driver);
        double vol = 0;
        String strVol = "";
        executor.executeScript("jwplayer().setVolume(" + volume + ")");
        System.out.println(executor.executeScript("return jwplayer().getVolume()"));
        strVol = String.valueOf(executor.executeScript("return jwplayer().getVolume()"));
        vol = Double.parseDouble(strVol);
        if (vol == volume) return true;
        else return false;
    }

    public boolean assertStateMuteFalse() throws InterruptedException {
        waitForPlayer(driver);
        executor.executeScript("jwplayer().setMute(false)");
        System.out.println(executor.executeScript("return jwplayer().getMute()"));
        return executor.executeScript("return jwplayer().getMute()").equals(false);
    }

    public boolean assertStatePause() throws InterruptedException {
        waitForPlayer(driver);
        executor.executeScript("jwplayer().pause()");
        System.out.println(executor.executeScript("return jwplayer().getState()"));
        return executor.executeScript("return jwplayer().getState()").equals("buffering") ||
                executor.executeScript("return jwplayer().getState()").equals("paused");
    }

    public boolean assertStateRetrocede45mins() throws InterruptedException {
        return rewind(2700);
    }

    public boolean assertStateAvanza130secs() throws InterruptedException {
        return fastForward(130);
    }

    public boolean assertStateRetrocede30secs() throws InterruptedException {
        return rewind(30);
    }
}
