/**
 * @name : PropAbbrController
 *
 * @author: lenovo
 * @date : 17.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InterfaceModel;
import view.InterfaceView;

public class PropAbbrController
        extends InterfaceController
        implements ActionListener
{
    public PropAbbrController(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnPropAbbrechen().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.getFrmProperties().setVisible(false);
    }
}