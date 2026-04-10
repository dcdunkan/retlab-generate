package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class QuizFileItemBinding implements ViewBinding {
    public final ImageView fileDownload;
    public final ImageView fileIcon;
    public final TextView fileName;
    public final TextView fileType;
    private final LinearLayout rootView;

    private QuizFileItemBinding(LinearLayout rootView, ImageView fileDownload, ImageView fileIcon, TextView fileName, TextView fileType) {
        this.rootView = rootView;
        this.fileDownload = fileDownload;
        this.fileIcon = fileIcon;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static QuizFileItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QuizFileItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quiz_file_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QuizFileItemBinding bind(View rootView) {
        int i = R.id.file_download;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.file_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.file_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.file_type;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new QuizFileItemBinding((LinearLayout) rootView, imageView, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}