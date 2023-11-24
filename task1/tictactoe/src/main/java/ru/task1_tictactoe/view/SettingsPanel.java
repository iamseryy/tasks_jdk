package ru.task1_tictactoe.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private static final String SIZE_SETTINGS_TITLE = "Difficulty";
    private static final String SET_FIELD_SIZE_LABEL = "Field size:";
    private static final String SET_FIELD_LENGTH_LABEL = "Length to win:";
    private static final JLabel setFieldSizeLabel = new JLabel(SET_FIELD_SIZE_LABEL, JLabel.LEFT);
    private static final JLabel setFieldLengthLabel = new JLabel(SET_FIELD_LENGTH_LABEL, JLabel.LEFT);
    private static final JSlider fieldSizeLabelSlider = new JSlider(3, 10);
    private static final JSlider fieldLengthLabelSlider = new JSlider(3, 10);
    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);


    public SettingsPanel() {
        init();
        addListeners();
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(SIZE_SETTINGS_TITLE),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        var gridBagConstraints = creatGridBagConstraints(0, 0);
        add(setFieldSizeLabel, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 1);
        add(fieldSizeLabelSlider, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 2);
        add(setFieldLengthLabel, gridBagConstraints);
        gridBagConstraints = creatGridBagConstraints(0, 3);
        add(fieldLengthLabelSlider, gridBagConstraints);
    }

    private void addListeners() {
        fieldSizeLabelSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setFieldSizeLabel.setText(SET_FIELD_SIZE_LABEL + " " + fieldSizeLabelSlider.getValue());
            }
        });

        fieldLengthLabelSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setFieldLengthLabel.setText(SET_FIELD_LENGTH_LABEL + " " + fieldLengthLabelSlider.getValue());
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

}
