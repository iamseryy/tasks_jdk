package ru.task1_tictactoe.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private int fieldSize;
    private int winLength;
    private static final String SIZE_SETTINGS_TITLE = "Difficulty";
    private static final String SET_FIELD_SIZE_LABEL = "Field size:";
    private static final String SET_FIELD_LENGTH_LABEL = "Length to win:";
    private static final JLabel setFieldSizeLabel = new JLabel(SET_FIELD_SIZE_LABEL, JLabel.LEFT);
    private static final JLabel setFieldLengthLabel = new JLabel(SET_FIELD_LENGTH_LABEL, JLabel.LEFT);
    private static final JSlider fieldSizeSlider = new JSlider(3, 10);
    private static final JSlider fieldLengthSlider = new JSlider(3, 10);
    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);


    public SettingsPanel(int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLength = winLength;

        init();
        addListeners();
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(SIZE_SETTINGS_TITLE),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        var gridBagConstraints = creatGridBagConstraints(0, 0);

        setFieldSizeLabel.setText(SET_FIELD_SIZE_LABEL + " " + fieldSize);
        setFieldLengthLabel.setText(SET_FIELD_LENGTH_LABEL + " " + winLength);
        fieldSizeSlider.setValue(fieldSize);
        fieldLengthSlider.setMaximum(fieldSize);
        fieldLengthSlider.setValue(winLength);

        add(setFieldSizeLabel, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 1);
        add(fieldSizeSlider, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 2);
        add(setFieldLengthLabel, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 3);
        add(fieldLengthSlider, gridBagConstraints);
    }

    private void addListeners() {
        fieldSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fieldSize =  fieldSizeSlider.getValue();
                setFieldSizeLabel.setText(SET_FIELD_SIZE_LABEL + " " + fieldSize);
                fieldLengthSlider.setMaximum(fieldSize);
            }
        });

        fieldLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLength = fieldLengthSlider.getValue();
                setFieldLengthLabel.setText(SET_FIELD_LENGTH_LABEL + " " + winLength);
            }
        });
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

    public int getFieldSize() {
        return fieldSize;
    }

    public int getWinLength() {
        return winLength;
    }
}
