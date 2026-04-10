package in.etuwa.app.ui.exam;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.exam.ExamFiles;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExamListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ExamListener {
    boolean checkFileExistence(String fileName);

    void deleteExam(String id);

    void downloadFile(String url, int position);

    void onDismiss();

    void onPickDoc(String id);

    void openDownloadDialog(ArrayList<ExamFiles> list);
}