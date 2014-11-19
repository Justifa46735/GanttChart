/**
 * @name : ZoomOutController
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

public class ZoomOutController
        extends InterfaceController
        implements ActionListener
{
    public ZoomOutController(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnZoomOut().addActionListener(this);
        view.getMnuZoomOut().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.getChartPanel().zoomOutBoth(5, 0);
    }
}
