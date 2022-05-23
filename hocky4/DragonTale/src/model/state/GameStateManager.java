package model.state;

import java.util.ArrayList;

import controller.ControllerGameOver;
import controller.ControllerGameVictory;
import controller.ControllerLevel1State;
import controller.ControllerMenuState;
import controller.IContronller;
import observer.DataTime;

public class GameStateManager {

	private ArrayList<AState> gameStates;
	private ArrayList<IContronller> ctrls;
	private int currentState;

	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	public static final int GAMEOVER = 2;
	public static final int GAMEWON = 3;

	private IContronller ctrlState;

	public GameStateManager(DataTime data) {

		gameStates = new ArrayList<AState>();
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this, data));
		gameStates.add(new GameOverState(this));
		gameStates.add(new VictoryState(this));

		init();

	}

	public void init() {
		ctrls = new ArrayList<IContronller>();
		ctrls.add(new ControllerMenuState((MenuState) gameStates.get(MENUSTATE)));
		ctrls.add(new ControllerLevel1State((Level1State) gameStates.get(LEVEL1STATE)));
		ctrls.add(new ControllerGameOver((GameOverState) gameStates.get(GAMEOVER)));
		ctrls.add(new ControllerGameVictory((VictoryState) gameStates.get(GAMEWON)));

		ctrlState = ctrls.get(MENUSTATE);
	}

	public ArrayList<AState> getGameStates() {
		return gameStates;
	}

	public void setGameStates(ArrayList<AState> gameStates) {
		this.gameStates = gameStates;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
		ctrlState = ctrls.get(currentState);
	}


	public IContronller getCtrlState() {
		return ctrlState;
	}

	public void setCtrlState(IContronller ctrlState) {
		this.ctrlState = ctrlState;
	}

}
