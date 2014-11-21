/**
 * @name : OpenInfoFrmCntrl
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

public class OpenInfoFrmCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    public OpenInfoFrmCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getMnuInfo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        StringBuilder msg = new StringBuilder();
        msg.append("Version GUI: ");
        msg.append(view.getVersion());
        msg.append("\n");
        msg.append("Version Model: ");
        msg.append(model.getVersion());
        msg.append("\n");

        view.showInfoMsg(msg.toString());
    }
}
