package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTeacherBinding implements ViewBinding {
    public final ImageView image;
    private final CardView rootView;
    public final TextView teacherEmail;
    public final TextView teacherName;
    public final TextView teacherPhone;
    public final TextView teacherSubject;

    private RowTeacherBinding(CardView rootView, ImageView image, TextView teacherEmail, TextView teacherName, TextView teacherPhone, TextView teacherSubject) {
        this.rootView = rootView;
        this.image = image;
        this.teacherEmail = teacherEmail;
        this.teacherName = teacherName;
        this.teacherPhone = teacherPhone;
        this.teacherSubject = teacherSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTeacherBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTeacherBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_teacher, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTeacherBinding bind(View rootView) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.teacher_email;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.teacher_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.teacher_phone;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.teacher_subject;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new RowTeacherBinding((CardView) rootView, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}