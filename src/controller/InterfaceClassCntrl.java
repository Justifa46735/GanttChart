/**
 * @name : InterfaceClassCntrl
 *
 * @author: lenovo
 * @date : 21.11.2014
 *
 * @brief :
 *
 */
package controller;

import model.InterfaceModel;
import view.InterfaceView;

public abstract class InterfaceClassCntrl
        implements InterfaceController
{
    protected final InterfaceView view;
    protected final InterfaceModel model;

    public InterfaceClassCntrl(InterfaceView view, InterfaceModel model)
    {
        this.view = view;
        this.model = model;
    }
}
