package in.etuwa.app.ui.leave.duty;

import android.content.Context;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import in.etuwa.app.data.network.ApiEndPoints;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.data.network.VolleyController;
import in.etuwa.app.data.preference.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: DutyLeaveTask.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DutyLeaveTask implements KoinComponent {
    private final Context context;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public DutyLeaveTask(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        final DutyLeaveTask dutyLeaveTask = this;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = dutyLeaveTask;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier2, function0);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final void applyBtnDutyFull(final CallBackResponse callBackResponse, final String id) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_APPLY_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda0
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.applyBtnDutyFull$lambda$0(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda9
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.applyBtnDutyFull$lambda$1(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$applyBtnDutyFull$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.applyBtnDutyFull.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBtnDutyFull$lambda$0(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBtnDutyFull$lambda$1(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void statusBtnFullDuty(final CallBackResponse callBackResponse, final String id) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_STATUS_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda7
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.statusBtnFullDuty$lambda$2(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda8
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.statusBtnFullDuty$lambda$3(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$statusBtnFullDuty$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.statusBtnFullDuty.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void statusBtnFullDuty$lambda$2(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void statusBtnFullDuty$lambda$3(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void applyFullDay(final CallBackResponse callBackResponse, final String id, final String date) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        Intrinsics.checkNotNullParameter(date, "date");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_APPLY_FULL_DAY_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda1
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.applyFullDay$lambda$4(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda2
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.applyFullDay$lambda$5(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$applyFullDay$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                jSONObject.put("date", date);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.applyFullDay.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyFullDay$lambda$4(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyFullDay$lambda$5(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void cancelFullDay(final CallBackResponse callBackResponse, final String id, final String date) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        Intrinsics.checkNotNullParameter(date, "date");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_CANCEL_FULL_DAY_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda16
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.cancelFullDay$lambda$6(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda17
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.cancelFullDay$lambda$7(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$cancelFullDay$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                jSONObject.put("date", date);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.cancelFullDay.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelFullDay$lambda$6(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelFullDay$lambda$7(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void applyHourDutyDates(final CallBackResponse callBackResponse, final String id) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_APPLY_HOUR_DATES_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda12
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.applyHourDutyDates$lambda$8(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda13
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.applyHourDutyDates$lambda$9(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$applyHourDutyDates$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.applyHourDutyDates.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHourDutyDates$lambda$8(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHourDutyDates$lambda$9(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void statusBtnHourDuty(final CallBackResponse callBackResponse, final String id, final String date) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        Intrinsics.checkNotNullParameter(date, "date");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_STATUS_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.statusBtnHourDuty$lambda$10(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda6
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.statusBtnHourDuty$lambda$11(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$statusBtnHourDuty$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                jSONObject.put("date", date);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.statusBtnHourDuty.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void statusBtnHourDuty$lambda$10(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void statusBtnHourDuty$lambda$11(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void applyBtnDutyHour(final CallBackResponse callBackResponse, final String id, final String date) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        Intrinsics.checkNotNullParameter(date, "date");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_APPLY_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda3
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.applyBtnDutyHour$lambda$12(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.applyBtnDutyHour$lambda$13(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$applyBtnDutyHour$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                jSONObject.put("date", date);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.applyBtnDutyHour.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBtnDutyHour$lambda$12(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBtnDutyHour$lambda$13(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void applyHour(final CallBackResponse callBackResponse, final String id, final String date, final String period) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(period, "period");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_APPLY_HOUR_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda14
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.applyHour$lambda$14(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda15
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.applyHour$lambda$15(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$applyHour$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                jSONObject.put("date", date);
                jSONObject.put("hour", period);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.applyHour.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHour$lambda$14(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHour$lambda$15(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }

    public final void cancelHour(final CallBackResponse callBackResponse, final String id, final String date, final String period) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(period, "period");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.DUTY_CANCEL_HOUR_URL;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda10
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                DutyLeaveTask.cancelHour$lambda$16(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$$ExternalSyntheticLambda11
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                DutyLeaveTask.cancelHour$lambda$17(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask$cancelHour$dutyReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }

            @Override // com.android.volley.Request
            public byte[] getBody() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", id);
                jSONObject.put("date", date);
                jSONObject.put("hour", period);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "rawBody.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveTask.cancelHour.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelHour$lambda$16(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelHour$lambda$17(DutyLeaveTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error...!", 0).show();
    }
}