package ru.task1_tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class GameModePanel extends JPanel {
    private static final String SELECT_GAME_MODE_TITLE = "Select game mode";
    private static final String HUMAN_AI_TITLE = "Human vs AI";
    private static final String HUMAN_HUMAN_TITLE = "Human vs Human";
    private static final JRadioButton humanVsAi = new JRadioButton(HUMAN_AI_TITLE);
    private static final JRadioButton humanVsHuman = new JRadioButton(HUMAN_HUMAN_TITLE);
    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
    private static final ButtonGroup gameModeButtonsGroup = new ButtonGroup();

    public GameModePanel() {
        init();
        addListeners();
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(SELECT_GAME_MODE_TITLE),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        var gridBagConstraints = creatGridBagConstraints(0, 0);
        add(humanVsAi, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 1);
        add(humanVsHuman, gridBagConstraints);

        gameModeButtonsGroup.add(humanVsAi);
        gameModeButtonsGroup.add(humanVsHuman);
        humanVsAi.setSelected(true);
    }

    private void addListeners() {

    }

    private GridBagConstraints creatGridBagConstraints(int x, int y) {
        var gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        gridBagConstraints.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gridBagConstraints.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        gridBagConstraints.weightx = (x == 0) ? 0.1 : 1.0;
        gridBagConstraints.weighty = 1.0;

        return gridBagConstraints;
    }

    public int getGameMode(){
        return humanVsAi.isSelected() ? 0 : 1;
    }

    public String getGameModeDesc(){
        return humanVsAi.isSelected() ? HUMAN_AI_TITLE : HUMAN_HUMAN_TITLE;
    }

}
