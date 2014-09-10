package org.jutility.math.vectorAlgebra;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The {@link Vector4d} class provides a convenience implementation of the
 * {@link IVector4} interface for {@link Double Doubles}.
 * 
 * @author Peter J. Radics
 * @version 1.0
 */
@XmlRootElement(name = "Vector4d")
@XmlType(name = "Vector4d")
public class Vector4d
        extends Vector4<Double>
        implements IVector4<Double> {

    /**
     * The i unit vector.
     */
    public static final Vector4d I_UNIT_VECTOR = new Vector4d(1, 0, 0);
    /**
     * The j unit vector.
     */
    public static final Vector4d J_UNIT_VECTOR = new Vector4d(0, 1, 0);
    /**
     * The k unit vector.
     */
    public static final Vector4d K_UNIT_VECTOR = new Vector4d(0, 0, 1);
    /**
     * The null vector.
     */
    public static final Vector4d NULL_VECTOR   = new Vector4d(0, 0, 0);


    /**
     * Creates a new instance of the {@link Vector4d} class. (Serialization
     * Constructor)
     */
    @SuppressWarnings("unused")
    private Vector4d() {

        super();
    }

    /**
     * Creates a new instance of the {@link Vector4d} class with the provided
     * values.
     * 
     * @param x
     *            The X coordinate.
     * @param y
     *            The Y coordinate.
     * @param z
     *            The Y coordinate.
     */
    public Vector4d(final Number x, final Number y, final Number z) {

        super(x, y, z, Double.class);
    }


    /**
     * Copy constructor.
     * 
     * Creates a new vector from the tuple provided.
     * 
     * @param tuple
     *            The tuple to be copied.
     * @throws IllegalArgumentException
     *             if the tuple provided is not a vector
     */
    public Vector4d(final ITuple4<Double> tuple) {

        super(tuple);
    }

}