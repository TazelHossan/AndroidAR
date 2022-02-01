package com.example.artest;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
//import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArFragment arFragment;
    private ModelRenderable bearRenderable,
                            catRenderable,
                            cowRenderable,
                            dogRenderable,
                            elephantRenderable,
                            ferretRenderable,
                            hippoRenderable,
                            hourseRenderable,
                            koaloaRenderable,
                            lionRenderable,
                            reindeerRenderable,
                            wolverineRenderable;
    ImageView bear, cat , cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine;

    View arrayView[];
    ViewRenderable name_animal;

    int selected = 1;
     ViewRenderable animal_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        bear = (ImageView)findViewById(R.id.bear);
        cat = (ImageView)findViewById(R.id.cat);
        cow = (ImageView)findViewById(R.id.cow);
        dog = (ImageView)findViewById(R.id.dog);
        elephant = (ImageView)findViewById(R.id.elephant);
        ferret = (ImageView)findViewById(R.id.ferret);
        hippo = (ImageView)findViewById(R.id.hippopotamus);
        horse = (ImageView)findViewById(R.id.horse);
        koala = (ImageView)findViewById(R.id.koala_bear);
        lion = (ImageView)findViewById(R.id.lion);
        reindeer = (ImageView)findViewById(R.id.reindeer);
        wolverine = (ImageView)findViewById(R.id.wolverine);

        Quaternion rotation180 = Quaternion.axisAngle(new Vector3(0.0f, 0.0f, 1.0f), 180);
        setArrayView();
        setClickListener();

        setupModel();
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                //if(selected==1)
                //{
                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode, selected);
                    anchorNode.setLocalRotation(rotation180);
                //}
            }
        });



    }

    private void setupModel() {

        ViewRenderable.builder()
                .setView(this,R.layout.name_animal)
                .build()
                .thenAccept(renderable -> name_animal= renderable );

        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build()
                .thenAccept(renderable -> bearRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Bear", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build()
                .thenAccept(renderable -> catRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load cat", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build()
                .thenAccept(renderable -> cowRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load cow", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build()
                .thenAccept(renderable -> dogRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Dog", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build()
                .thenAccept(renderable -> elephantRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Elephant", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build()
                .thenAccept(renderable -> ferretRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Ferret", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build()
                .thenAccept(renderable -> hippoRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Hippopotamus", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build()
                .thenAccept(renderable -> hourseRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Horse", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build()
                .thenAccept(renderable -> koaloaRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Koala Bear", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build()
                .thenAccept(renderable -> lionRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Lion", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build()
                .thenAccept(renderable -> reindeerRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Reinder", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build()
                .thenAccept(renderable -> wolverineRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load Wolverine", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return null;
                        });


    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if(selected==1)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode,bear,"Bear");
        }

        if(selected==2)
        {
            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());
            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();

            addName(anchorNode,cat,"Cat");
        }

        if(selected==3)
        {
            TransformableNode cow = new TransformableNode(arFragment.getTransformationSystem());
            cow.setParent(anchorNode);
            cow.setRenderable(cowRenderable);
            cow.select();

            addName(anchorNode,cow,"Cow");
        }

        if(selected==4)
        {
            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());
            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();

            addName(anchorNode,dog,"Dog");
        }

        if(selected==5)
        {
            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());
            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRenderable);
            elephant.select();

            addName(anchorNode,elephant,"Elephant");
        }

        if(selected==6)
        {
            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());
            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();

            addName(anchorNode,ferret,"Ferret");
        }

        if(selected==7)
        {
            TransformableNode hippo = new TransformableNode(arFragment.getTransformationSystem());
            hippo.setParent(anchorNode);
            hippo.setRenderable(hippoRenderable);
            hippo.select();

            addName(anchorNode,hippo,"Hippop");
        }

        if(selected==8)
        {
            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());
            horse.setParent(anchorNode);
            horse.setRenderable(hourseRenderable);
            horse.select();

            addName(anchorNode,horse,"Hourse");
        }
        if(selected==9)
        {
            TransformableNode koala = new TransformableNode(arFragment.getTransformationSystem());
            koala.setParent(anchorNode);
            koala.setRenderable(koaloaRenderable);
            koala.select();

            addName(anchorNode,koala,"Koaloa");
        }

        if(selected==10)
        {
            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());
            lion.setParent(anchorNode);
            lion.setRenderable(lionRenderable);
            lion.select();

            addName(anchorNode,lion,"Lion");
        }
        if(selected==11)
        {
            TransformableNode reindeer = new TransformableNode(arFragment.getTransformationSystem());
            reindeer.setParent(anchorNode);
            reindeer.setRenderable(reindeerRenderable);
            reindeer.select();

            addName(anchorNode,reindeer,"Reindeer");
        }

        if(selected==12)
        {
            TransformableNode wolverine = new TransformableNode(arFragment.getTransformationSystem());
            wolverine.setParent(anchorNode);
            wolverine.setRenderable(wolverineRenderable);
            wolverine.select();

            addName(anchorNode,wolverine,"Wolve");
        }

    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
        nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
        nameView.setParent(anchorNode);
        nameView.setRenderable(name_animal);
        nameView.select();

        TextView txt_name = (TextView)name_animal.getView();
        txt_name.setText(name);

        txt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchorNode.setParent(null);
            }
        });
    }

    private void setClickListener() {
        for(int i =0; i<arrayView.length; i++)
            arrayView[i].setOnClickListener(this);

    }

    private void setArrayView() {
        arrayView = new View[]{
                bear, cat , cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine

        };
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bear)
        {
            selected=1;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.cat)
        {
            selected=2;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.cow)
        {
            selected=3;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.dog)
        {
            selected=4;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.elephant)
        {
            selected=5;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.ferret)
        {
            selected=6;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.hippopotamus)
        {
            selected=7;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.horse)
        {
            selected=8;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.koala_bear)
        {
            selected=9;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.lion)
        {
            selected=10;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.reindeer)
        {
            selected=11;
            setBackground(view.getId());
        }
        else if(view.getId()==R.id.wolverine)
        {
            selected=12;
            setBackground(view.getId());

        }

    }

    private void setBackground(int id) {
        for(int i =0; i<arrayView.length; i++)
        {
            if (arrayView[i].getId()==id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }
}