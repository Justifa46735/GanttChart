/**
 * @name : PropertiesController
 *
 * @author: lenovo
 * @date : 16.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InterfaceModel;
import view.InterfaceView;

public class OpenPropFrmCntrl
        extends InterfaceController
        implements ActionListener
{
    public OpenPropFrmCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getMnuProperties().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.getFrmProperties().getTfPropProjektName().setText(model.getProjektName());
        view.getFrmProperties().getTfPropProjektName().grabFocus();
        view.getFrmProperties().getTfPropProjektName().selectAll();
        view.getFrmProperties().setVisible(true);
    }
}
