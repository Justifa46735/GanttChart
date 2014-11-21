/**
 * @name : PropBestController
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

public class PropConfirmCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    public PropConfirmCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnPropBestaetigen().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String newProjName = view.getTfPropProjektName().getText();
        model.setProjektName(newProjName);
        view.getFrmProperties().setVisible(false);
    }
}
