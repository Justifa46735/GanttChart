/**
 * @name : InsertTaskCntrl
 *
 * @author: lenovo
 * @date : 19.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InterfaceModel;
import view.InterfaceView;

public class InsertTaskCntrl
        extends InterfaceController
        implements ActionListener
{
    public InsertTaskCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnInsert().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}
