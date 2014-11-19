/**
 * @name : ZoomInController
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

public class ZoomInController
        extends InterfaceController
        implements ActionListener
{
    public ZoomInController(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnZoomIn().addActionListener(this);
        view.getMnuZoomIn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.getChartPanel().zoomInBoth(5, 0);
    }
}
