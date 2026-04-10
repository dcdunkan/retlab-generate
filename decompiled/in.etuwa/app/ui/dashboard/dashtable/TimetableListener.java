package in.etuwa.app.ui.dashboard.dashtable;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimetableListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TimetableListener {
    void loadDate(String position);

    void loadPage();

    void onNextWeekRequested();

    void onPreviousWeekRequested();
}