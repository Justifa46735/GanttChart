/**
 * @name : IntController
 *
 * @author: lenovo
 * @date : 17.11.2014
 *
 * @brief :
 *
 */
package controller;

import model.InterfaceModel;
import view.InterfaceView;

public abstract class InterfaceController
{
    protected final InterfaceView view;
    protected final InterfaceModel model;

    public InterfaceController(InterfaceView view, InterfaceModel model)
    {
        this.view = view;
        this.model = model;
    }

    public abstract void registerEvents();
}
