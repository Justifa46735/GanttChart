/**
 * @name : ZoomNormalController
 *
 * @author: lenovo
 * @date : 11.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InterfaceModel;
import view.InterfaceView;

public class ZoomNormalCntrl
        extends InterfaceController
        implements ActionListener
{
    public ZoomNormalCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnZoomNormal().addActionListener(this);
        view.getMnuZoomNormal().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.getChartPanel().restoreAutoBounds();
    }
}
