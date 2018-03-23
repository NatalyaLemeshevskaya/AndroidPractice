package com.natallialemiasheuskaya.presentation.sreens.homework3;

import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.natallialemiasheuskaya.presentation.base.BaseViewModel;
import com.natallialemiasheuskaya.presentation.sreens.homework1.BuildConfig;
import com.squareup.picasso.Picasso;

public class HW3ViewModel extends BaseViewModel {


    public ObservableField<String> textWow = new ObservableField<>("");
    public ObservableField<String> textButtonTree = new ObservableField<>("Would you like to see a beautiful tree?");
    public ObservableField<String> textEdit = new ObservableField<>
            ("https://us.123rf.com/450wm/smileus/smileus1504/smileus150400005/39155225-идеальный-ясень-с-пышной-зеленой-листвой-и-хорошей-форме-изолированных-на-чистом-белом-фоне.jpg?ver=6");
    public ObservableBoolean imageVisible = new ObservableBoolean(false);

    public String getImageUlr(){
        return "https://us.123rf.com/450wm/smileus/smileus1504/smileus150400005/39155225-идеальный-ясень-с-пышной-зеленой-листвой-и-хорошей-форме-изолированных-на-чистом-белом-фоне.jpg?ver=6";
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImageUrl(ImageView imageView, String url){
        Picasso.with(imageView.getContext()).load(url).transform(new CircularTransformation()).into(imageView);
    }

    public void onClick(){
        textWow.set(BuildConfig.API_ENDPOINT);
        imageVisible.set(true);
    }

    @Override
    public void createInject() {

    }
}
