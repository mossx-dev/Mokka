package Mokka.Shape;

import Mokka.Material;
import Mokka.Maths.Matrix4f;
import Mokka.Maths.Vector3f;
import Mokka.Options;
import Mokka.VertexArray;
import Mokka.Window;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractShape {

    static public HashMap<AbstractShape, Boolean> ShapeList = new HashMap<>();
    Material material = Options.getDefaultMaterial();
    VertexArray va;
    Matrix4f translation = new Matrix4f(1);
    public ArrayList<AbstractShape> children = new ArrayList<>();
    final int[] indices = null;

    public AbstractShape() {
        ShapeList.put(this, Options.AutoDraw);
    }


    public void draw() {
        Window.draw(this);
    }

    public void translate(float x, float y, float z) {
        translation.translate(x, y, z);
    }

    public void translate(Vector3f vec) {
        translation.translate(vec);
        for (AbstractShape child : children) {
            child.translate(vec);
        }
    }

    public Matrix4f getTranslation() {
        return translation;
    }

    public void addChild(AbstractShape child) {
        this.children.add(child);
    }


    public abstract AbstractShape copy();

}

