package org.jutility.math.geometry;


import org.jutility.math.vectorAlgebra.IVector4;


/**
 * The {@link IRotation} interface provides a contract for classes implementing
 * axis-angle rotations.
 * 
 * @author Peter J. Radics
 * @version 1.0
 * @param <T>
 *            The type of the rotation
 */
public interface IRotation<T extends Number>
        extends IRotationBase<T> {


    /**
     * Returns the rotation axis.
     * 
     * @return the rotation axis.
     */
    @Override
    public IVector4<T> getAxis();

}