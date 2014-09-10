package org.jutility.math.geometry;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.jutility.math.vectorAlgebra.IPoint4;
import org.jutility.math.vectorAlgebra.Point4;


/**
 * The generic {@link Line4} class provides a reference implementation of the
 * {@link ILine4} interface.
 * 
 * @author Peter J. Radics
 * @version 1.0
 * @param <T>
 *            the type of the line.
 * 
 */
@XmlRootElement(name = "Line4")
@XmlType(name = "Line4")
public class Line4<T extends Number>
        implements ILine4<T> {

    @XmlAttribute
    private final Class<? extends T> type;

    @XmlElement(name = "Source", type = Point4.class)
    private final IPoint4<T>         source;
    @XmlElement(name = "Sink", type = Point4.class)
    private final IPoint4<T>         sink;

    @Override
    public IPoint4<T> getSource() {

        return this.source;
    }


    @Override
    public Class<? extends T> getType() {

        return this.type;
    }

    @Override
    public IPoint4<T> getSink() {

        return this.sink;
    }


    /**
     * Creates a new instance of the {@link Line4} class. (Serialization
     * Constructor)
     */
    protected Line4() {

        this(null, null, null, true);
    }

    /**
     * Creates a new instance of the {@link Line4} class with the provided type
     * and parameters.
     * 
     * @param source
     *            the source of the line.
     * @param sink
     *            the sink of the line.
     * @param type
     *            the type.
     */
    public Line4(final IPoint4<? extends Number> source,
            final IPoint4<? extends Number> sink, final Class<? extends T> type) {

        this(source, sink, type, false);
    }

    /**
     * Creates a new instance of the {@link Line4} class with the provided type
     * and parameters.
     * 
     * @param source
     *            the source of the line.
     * @param sink
     *            the sink of the line.
     * @param type
     *            the type.
     * @param serialization
     *            whether or not the constructor is invoked during
     *            serialization.
     */
    public Line4(final IPoint4<? extends Number> source,
            final IPoint4<? extends Number> sink,
            final Class<? extends T> type, final boolean serialization) {

        if (source == null && !serialization) {
            throw new IllegalArgumentException(
                    "Cannot create a line without a source point!");
        }
        if (sink == null && !serialization) {
            throw new IllegalArgumentException(
                    "Cannot create a line without a sink point!");
        }
        if (type == null && !serialization) {

            throw new IllegalArgumentException(
                    "Cannot create a line without a type!");

        }

        if (source != null && type != null) {
            this.source = new Point4<T>(source, type);
        }
        else {
            this.source = null;
        }
        if (sink != null && type != null) {
            this.sink = new Point4<T>(sink, type);
        }
        else {
            this.sink = null;
        }

        this.type = type;
    }


    /**
     * Copy Constructor.
     * 
     * @param lineToCopy
     *            the line to copy.
     */
    public Line4(final ILine4<T> lineToCopy) {

        this(lineToCopy, lineToCopy.getType());
    }

    /**
     * Copy Constructor.
     * 
     * @param lineToCopy
     *            the line to copy.
     * @param type
     *            the desired type of the line to copy.
     */
    public Line4(final ILine4<? extends Number> lineToCopy,
            final Class<? extends T> type) {

        this(lineToCopy.getSource(), lineToCopy.getSink(), type);
    }


    @Override
    public String toString() {

        return "Line4 from " + this.getSource() + " to " + this.getSink();
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj != null && obj instanceof ILine4<?>) {
            ILine4<?> other = (ILine4<?>) obj;

            boolean sameSource = this.getSource().equals(other.getSource());
            boolean sameSink = this.getSink().equals(other.getSink());

            return sameSource && sameSink;
        }
        return false;
    }

    @Override
    public int hashCode() {

        int hash = 7;

        hash += 11 * this.getSource().hashCode();
        hash += 13 * this.getSink().hashCode();

        return hash;
    }

}
