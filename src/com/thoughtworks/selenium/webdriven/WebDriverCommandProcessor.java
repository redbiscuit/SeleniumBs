//package com.thoughtworks.selenium.webdriven;
//
//import com.google.common.annotations.VisibleForTesting;
//import com.google.common.base.Supplier;
//import com.google.common.collect.Maps;
//import com.thoughtworks.selenium.CommandProcessor;
//import com.thoughtworks.selenium.SeleniumException;
//import com.thoughtworks.selenium.webdriven.*;
//import com.thoughtworks.selenium.webdriven.commands.AddLocationStrategy;
//import com.thoughtworks.selenium.webdriven.commands.AddSelection;
//import com.thoughtworks.selenium.webdriven.commands.AlertOverride;
//import com.thoughtworks.selenium.webdriven.commands.AllowNativeXPath;
//import com.thoughtworks.selenium.webdriven.commands.AltKeyDown;
//import com.thoughtworks.selenium.webdriven.commands.AltKeyUp;
//import com.thoughtworks.selenium.webdriven.commands.AssignId;
//import com.thoughtworks.selenium.webdriven.commands.AttachFile;
//import com.thoughtworks.selenium.webdriven.commands.CaptureScreenshotToString;
//import com.thoughtworks.selenium.webdriven.commands.Check;
//import com.thoughtworks.selenium.webdriven.commands.Click;
//import com.thoughtworks.selenium.webdriven.commands.ClickAt;
//import com.thoughtworks.selenium.webdriven.commands.Close;
//import com.thoughtworks.selenium.webdriven.commands.ControlKeyDown;
//import com.thoughtworks.selenium.webdriven.commands.ControlKeyUp;
//import com.thoughtworks.selenium.webdriven.commands.CreateCookie;
//import com.thoughtworks.selenium.webdriven.commands.DeleteAllVisibleCookies;
//import com.thoughtworks.selenium.webdriven.commands.DeleteCookie;
//import com.thoughtworks.selenium.webdriven.commands.DeselectPopUp;
//import com.thoughtworks.selenium.webdriven.commands.DoubleClick;
//import com.thoughtworks.selenium.webdriven.commands.DragAndDrop;
//import com.thoughtworks.selenium.webdriven.commands.DragAndDropToObject;
//import com.thoughtworks.selenium.webdriven.commands.FindFirstSelectedOptionProperty;
//import com.thoughtworks.selenium.webdriven.commands.FindSelectedOptionProperties;
//import com.thoughtworks.selenium.webdriven.commands.FireEvent;
//import com.thoughtworks.selenium.webdriven.commands.FireNamedEvent;
//import com.thoughtworks.selenium.webdriven.commands.GetAlert;
//import com.thoughtworks.selenium.webdriven.commands.GetAllButtons;
//import com.thoughtworks.selenium.webdriven.commands.GetAllFields;
//import com.thoughtworks.selenium.webdriven.commands.GetAllLinks;
//import com.thoughtworks.selenium.webdriven.commands.GetAllWindowNames;
//import com.thoughtworks.selenium.webdriven.commands.GetAllWindowTitles;
//import com.thoughtworks.selenium.webdriven.commands.GetAttribute;
//import com.thoughtworks.selenium.webdriven.commands.GetAttributeFromAllWindows;
//import com.thoughtworks.selenium.webdriven.commands.GetBodyText;
//import com.thoughtworks.selenium.webdriven.commands.GetConfirmation;
//import com.thoughtworks.selenium.webdriven.commands.GetCookie;
//import com.thoughtworks.selenium.webdriven.commands.GetCookieByName;
//import com.thoughtworks.selenium.webdriven.commands.GetCssCount;
//import com.thoughtworks.selenium.webdriven.commands.GetElementHeight;
//import com.thoughtworks.selenium.webdriven.commands.GetElementIndex;
//import com.thoughtworks.selenium.webdriven.commands.GetElementPositionLeft;
//import com.thoughtworks.selenium.webdriven.commands.GetElementPositionTop;
//import com.thoughtworks.selenium.webdriven.commands.GetElementWidth;
//import com.thoughtworks.selenium.webdriven.commands.GetEval;
//import com.thoughtworks.selenium.webdriven.commands.GetExpression;
//import com.thoughtworks.selenium.webdriven.commands.GetHtmlSource;
//import com.thoughtworks.selenium.webdriven.commands.GetLocation;
//import com.thoughtworks.selenium.webdriven.commands.GetSelectOptions;
//import com.thoughtworks.selenium.webdriven.commands.GetTable;
//import com.thoughtworks.selenium.webdriven.commands.GetText;
//import com.thoughtworks.selenium.webdriven.commands.GetTitle;
//import com.thoughtworks.selenium.webdriven.commands.GetValue;
//import com.thoughtworks.selenium.webdriven.commands.GetXpathCount;
//import com.thoughtworks.selenium.webdriven.commands.GoBack;
//import com.thoughtworks.selenium.webdriven.commands.Highlight;
//import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;
//import com.thoughtworks.selenium.webdriven.commands.IsChecked;
//import com.thoughtworks.selenium.webdriven.commands.IsConfirmationPresent;
//import com.thoughtworks.selenium.webdriven.commands.IsCookiePresent;
//import com.thoughtworks.selenium.webdriven.commands.IsEditable;
//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
//import com.thoughtworks.selenium.webdriven.commands.IsOrdered;
//import com.thoughtworks.selenium.webdriven.commands.IsSomethingSelected;
//import com.thoughtworks.selenium.webdriven.commands.IsTextPresent;
//import com.thoughtworks.selenium.webdriven.commands.IsVisible;
//import com.thoughtworks.selenium.webdriven.commands.KeyDownNative;
//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
//import com.thoughtworks.selenium.webdriven.commands.KeyPressNative;
//import com.thoughtworks.selenium.webdriven.commands.KeyState;
//import com.thoughtworks.selenium.webdriven.commands.KeyUpNative;
//import com.thoughtworks.selenium.webdriven.commands.MetaKeyDown;
//import com.thoughtworks.selenium.webdriven.commands.MetaKeyUp;
//import com.thoughtworks.selenium.webdriven.commands.MouseEvent;
//import com.thoughtworks.selenium.webdriven.commands.MouseEventAt;
//import com.thoughtworks.selenium.webdriven.commands.NoOp;
//import com.thoughtworks.selenium.webdriven.commands.Open;
//import com.thoughtworks.selenium.webdriven.commands.OpenWindow;
//import com.thoughtworks.selenium.webdriven.commands.Refresh;
//import com.thoughtworks.selenium.webdriven.commands.RemoveAllSelections;
//import com.thoughtworks.selenium.webdriven.commands.RemoveSelection;
//import com.thoughtworks.selenium.webdriven.commands.RunScript;
//import com.thoughtworks.selenium.webdriven.commands.SelectFrame;
//import com.thoughtworks.selenium.webdriven.commands.SelectOption;
//import com.thoughtworks.selenium.webdriven.commands.SelectPopUp;
//import com.thoughtworks.selenium.webdriven.commands.SelectWindow;
//import com.thoughtworks.selenium.webdriven.commands.SetNextConfirmationState;
//import com.thoughtworks.selenium.webdriven.commands.SetTimeout;
//import com.thoughtworks.selenium.webdriven.commands.ShiftKeyDown;
//import com.thoughtworks.selenium.webdriven.commands.ShiftKeyUp;
//import com.thoughtworks.selenium.webdriven.commands.Submit;
//import com.thoughtworks.selenium.webdriven.commands.Type;
//import com.thoughtworks.selenium.webdriven.commands.TypeKeys;
//import com.thoughtworks.selenium.webdriven.commands.Uncheck;
//import com.thoughtworks.selenium.webdriven.commands.UseXPathLibrary;
//import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;
//import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
//import com.thoughtworks.selenium.webdriven.commands.WaitForPopup;
//import com.thoughtworks.selenium.webdriven.commands.WindowFocus;
//import com.thoughtworks.selenium.webdriven.commands.WindowMaximize;
//import java.util.Map;
//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.HasCapabilities;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.internal.WrapsDriver;
//
//public class WebDriverCommandProcessor implements CommandProcessor, WrapsDriver {
//	private final Map<String, SeleneseCommand<?>> seleneseMethods;
//	private final String baseUrl;
//	private final Timer timer;
//	private final CompoundMutator scriptMutator;
//	private boolean enableAlertOverrides;
//	private Supplier<WebDriver> maker;
//	private WebDriver driver;
//
//	 public static void main(String[] args) {
//
//	 }
//
//	public WebDriverCommandProcessor(String baseUrl, WebDriver driver) {
//		this(baseUrl, new ExplodingSupplier());
//		this.driver = driver;
//
//		assertDriverSupportsJavascript(driver);
//
//		setUpMethodMap();
//	}
//
//	public WebDriverCommandProcessor(String baseUrl, Supplier<WebDriver> maker) {
//		this.seleneseMethods = Maps.newHashMap();
//
//		this.enableAlertOverrides = true;
//
//		this.maker = maker;
//		this.baseUrl = baseUrl;
//		this.timer = new Timer(120000L);
//		this.scriptMutator = new CompoundMutator(baseUrl);
//	}
//
//	public WebDriver getWrappedDriver() {
//		return this.driver;
//	}
//
//	public String getRemoteControlServerLocation() {
//		throw new UnsupportedOperationException();
//	}
//
//	public String doCommand(String commandName, String[] args) {
//		Object val = execute(commandName, args);
//		if (val == null) {
//			return null;
//		}
//
//		return val.toString();
//	}
//
//	public void setExtensionJs(String s) {
//		throw new UnsupportedOperationException();
//	}
//
//	public void start() {
//		start(null);
//	}
//
//	public void start(String s) {
//		throw new UnsupportedOperationException("Unsure how to process: " + s);
//	}
//
//	public void start(Object o) {
//		if (this.driver != null) {
//			throw new SeleniumException(
//					"You may not start more than one session at a time");
//		}
//
//		this.driver = ((WebDriver) this.maker.get());
//
//		assertDriverSupportsJavascript(this.driver);
//
//		setUpMethodMap();
//	}
//
//	public void stop() {
//		this.timer.stop();
//		if (this.driver != null) {
//			this.driver.quit();
//		}
//		this.driver = null;
//	}
//
//	public String getString(String commandName, String[] args) {
//		return ((String) execute(commandName, args));
//	}
//
//	public String[] getStringArray(String commandName, String[] args) {
//		return ((String[]) execute(commandName, args));
//	}
//
//	public Number getNumber(String commandName, String[] args) {
//		return ((Number) execute(commandName, args));
//	}
//
//	public Number[] getNumberArray(String s, String[] strings) {
//		throw new UnsupportedOperationException();
//	}
//
//	public boolean getBoolean(String commandName, String[] args) {
//		return ((Boolean) execute(commandName, args)).booleanValue();
//	}
//
//	public boolean[] getBooleanArray(String s, String[] strings) {
//		throw new UnsupportedOperationException();
//	}
//
//	private Object execute(String commandName, String[] args) {
//		SeleneseCommand command = (SeleneseCommand) this.seleneseMethods
//				.get(commandName);
//		if (command == null) {
//			throw new UnsupportedOperationException(commandName);
//		}
//
//		return this.timer.run(command, this.driver, args);
//	}
//
//	public void addMutator(ScriptMutator mutator) {
//		this.scriptMutator.addMutator(mutator);
//	}
//
//	public boolean isMethodAvailable(String methodName) {
//		return this.seleneseMethods.containsKey(methodName);
//	}
//
//	public void addMethod(String methodName, SeleneseCommand<?> command) {
//		this.seleneseMethods.put(methodName, command);
//	}
//
//	public SeleneseCommand<?> getMethod(String methodName) {
//		return ((SeleneseCommand) this.seleneseMethods.get(methodName));
//	}
//
//	@VisibleForTesting
//	protected void assertDriverSupportsJavascript(WebDriver driver) {
//		if (!(driver instanceof JavascriptExecutor)) {
//			throw new IllegalStateException("Driver instance must support JS.");
//		}
//
//		if (!(driver instanceof HasCapabilities)) {
//			return;
//		}
//
//		if (!(((HasCapabilities) driver).getCapabilities()
//				.isJavascriptEnabled()))
//			throw new IllegalStateException("JS support must be enabled.");
//	}
//
//	public void setEnableAlertOverrides(boolean enableAlertOverrides) {
//		this.enableAlertOverrides = enableAlertOverrides;
//	}
//
//	private void setUpMethodMap() {
//		JavascriptLibrary javascriptLibrary = new JavascriptLibrary();
//		ElementFinder elementFinder = new ElementFinder(javascriptLibrary);
//		KeyState keyState = new KeyState();
//
//		AlertOverride alertOverride = new AlertOverride(
//				this.enableAlertOverrides);
//		Windows windows = new Windows(this.driver);
//
//		this.seleneseMethods.put("addLocationStrategy",
//				new AddLocationStrategy(elementFinder));
//		this.seleneseMethods.put("addSelection", new AddSelection(
//				javascriptLibrary, elementFinder));
//		this.seleneseMethods.put("allowNativeXpath", new AllowNativeXPath());
//		this.seleneseMethods.put("altKeyDown", new AltKeyDown(keyState));
//		this.seleneseMethods.put("altKeyUp", new AltKeyUp(keyState));
//		this.seleneseMethods.put("assignId", new AssignId(javascriptLibrary,
//				elementFinder));
//		this.seleneseMethods.put("attachFile", new AttachFile(elementFinder));
//		this.seleneseMethods.put("captureScreenshotToString",
//				new CaptureScreenshotToString());
//		this.seleneseMethods.put("click", new Click(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("clickAt", new ClickAt(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("check", new Check(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("chooseCancelOnNextConfirmation",
//				new SetNextConfirmationState(false));
//		this.seleneseMethods.put("chooseOkOnNextConfirmation",
//				new SetNextConfirmationState(true));
//		this.seleneseMethods.put("close", new Close());
//		this.seleneseMethods.put("createCookie", new CreateCookie());
//		this.seleneseMethods
//				.put("controlKeyDown", new ControlKeyDown(keyState));
//		this.seleneseMethods.put("controlKeyUp", new ControlKeyUp(keyState));
//		this.seleneseMethods.put("deleteAllVisibleCookies",
//				new DeleteAllVisibleCookies());
//		this.seleneseMethods.put("deleteCookie", new DeleteCookie());
//		this.seleneseMethods.put("deselectPopUp", new DeselectPopUp(windows));
//		this.seleneseMethods.put("doubleClick", new DoubleClick(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("dragdrop", new DragAndDrop(elementFinder));
//		this.seleneseMethods.put("dragAndDrop", new DragAndDrop(elementFinder));
//		this.seleneseMethods.put("dragAndDropToObject",
//				new DragAndDropToObject(elementFinder));
//		this.seleneseMethods.put("fireEvent", new FireEvent(elementFinder,
//				javascriptLibrary));
//		this.seleneseMethods.put("focus", new FireNamedEvent(elementFinder,
//				javascriptLibrary, "focus"));
//		this.seleneseMethods.put("getAlert", new GetAlert(alertOverride));
//		this.seleneseMethods.put("getAllButtons", new GetAllButtons());
//		this.seleneseMethods.put("getAllFields", new GetAllFields());
//		this.seleneseMethods.put("getAllLinks", new GetAllLinks());
//		this.seleneseMethods.put("getAllWindowNames", new GetAllWindowNames());
//		this.seleneseMethods
//				.put("getAllWindowTitles", new GetAllWindowTitles());
//		this.seleneseMethods.put("getAttribute", new GetAttribute(
//				javascriptLibrary, elementFinder));
//		this.seleneseMethods.put("getAttributeFromAllWindows",
//				new GetAttributeFromAllWindows());
//		this.seleneseMethods.put("getBodyText", new GetBodyText());
//		this.seleneseMethods.put("getConfirmation", new GetConfirmation(
//				alertOverride));
//		this.seleneseMethods.put("getCookie", new GetCookie());
//		this.seleneseMethods.put("getCookieByName", new GetCookieByName());
//		this.seleneseMethods.put("getElementHeight", new GetElementHeight(
//				elementFinder));
//		this.seleneseMethods.put("getElementIndex", new GetElementIndex(
//				elementFinder, javascriptLibrary));
//		this.seleneseMethods.put("getElementPositionLeft",
//				new GetElementPositionLeft(elementFinder));
//		this.seleneseMethods.put("getElementPositionTop",
//				new GetElementPositionTop(elementFinder));
//		this.seleneseMethods.put("getElementWidth", new GetElementWidth(
//				elementFinder));
//		this.seleneseMethods.put("getEval", new GetEval(this.scriptMutator));
//		this.seleneseMethods.put("getExpression", new GetExpression());
//		this.seleneseMethods.put("getHtmlSource", new GetHtmlSource());
//		this.seleneseMethods.put("getLocation", new GetLocation());
//		this.seleneseMethods.put("getSelectedId",
//				new FindFirstSelectedOptionProperty(javascriptLibrary,
//						elementFinder, "id"));
//		this.seleneseMethods.put("getSelectedIds",
//				new FindSelectedOptionProperties(javascriptLibrary,
//						elementFinder, "id"));
//		this.seleneseMethods.put("getSelectedIndex",
//				new FindFirstSelectedOptionProperty(javascriptLibrary,
//						elementFinder, "index"));
//		this.seleneseMethods.put("getSelectedIndexes",
//				new FindSelectedOptionProperties(javascriptLibrary,
//						elementFinder, "index"));
//		this.seleneseMethods.put("getSelectedLabel",
//				new FindFirstSelectedOptionProperty(javascriptLibrary,
//						elementFinder, "text"));
//		this.seleneseMethods.put("getSelectedLabels",
//				new FindSelectedOptionProperties(javascriptLibrary,
//						elementFinder, "text"));
//		this.seleneseMethods.put("getSelectedValue",
//				new FindFirstSelectedOptionProperty(javascriptLibrary,
//						elementFinder, "value"));
//		this.seleneseMethods.put("getSelectedValues",
//				new FindSelectedOptionProperties(javascriptLibrary,
//						elementFinder, "value"));
//		this.seleneseMethods.put("getSelectOptions", new GetSelectOptions(
//				javascriptLibrary, elementFinder));
//		this.seleneseMethods.put("getSpeed", new NoOp("0"));
//		this.seleneseMethods.put("getTable", new GetTable(elementFinder,
//				javascriptLibrary));
//		this.seleneseMethods.put("getText", new GetText(javascriptLibrary,
//				elementFinder));
//		this.seleneseMethods.put("getTitle", new GetTitle());
//		this.seleneseMethods.put("getValue", new GetValue(elementFinder));
//		this.seleneseMethods.put("getXpathCount", new GetXpathCount());
//		this.seleneseMethods.put("getCssCount", new GetCssCount());
//		this.seleneseMethods.put("goBack", new GoBack());
//		this.seleneseMethods.put("highlight", new Highlight(elementFinder,
//				javascriptLibrary));
//		this.seleneseMethods.put("isAlertPresent", new IsAlertPresent(
//				alertOverride));
//		this.seleneseMethods.put("isChecked", new IsChecked(elementFinder));
//		this.seleneseMethods.put("isConfirmationPresent",
//				new IsConfirmationPresent(alertOverride));
//		this.seleneseMethods.put("isCookiePresent", new IsCookiePresent());
//		this.seleneseMethods.put("isEditable", new IsEditable(elementFinder));
//		this.seleneseMethods.put("isElementPresent", new IsElementPresent(
//				elementFinder));
//		this.seleneseMethods.put("isOrdered", new IsOrdered(elementFinder,
//				javascriptLibrary));
//		this.seleneseMethods.put("isSomethingSelected",
//				new IsSomethingSelected(javascriptLibrary));
//		this.seleneseMethods.put("isTextPresent", new IsTextPresent(
//				javascriptLibrary));
//		this.seleneseMethods.put("isVisible", new IsVisible(elementFinder));
//		this.seleneseMethods.put("keyDown", new KeyEvent(elementFinder,
//				javascriptLibrary, keyState, "doKeyDown"));
//		this.seleneseMethods.put("keyDownNative", new KeyDownNative());
//		this.seleneseMethods.put("keyPress", new TypeKeys(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("keyPressNative", new KeyPressNative());
//		this.seleneseMethods.put("keyUp", new KeyEvent(elementFinder,
//				javascriptLibrary, keyState, "doKeyUp"));
//		this.seleneseMethods.put("keyUpNative", new KeyUpNative());
//		this.seleneseMethods.put("metaKeyDown", new MetaKeyDown(keyState));
//		this.seleneseMethods.put("metaKeyUp", new MetaKeyUp(keyState));
//		this.seleneseMethods.put("mouseOver", new MouseEvent(elementFinder,
//				javascriptLibrary, "mouseover"));
//		this.seleneseMethods.put("mouseOut", new MouseEvent(elementFinder,
//				javascriptLibrary, "mouseout"));
//		this.seleneseMethods.put("mouseDown", new MouseEvent(elementFinder,
//				javascriptLibrary, "mousedown"));
//		this.seleneseMethods.put("mouseDownAt", new MouseEventAt(elementFinder,
//				javascriptLibrary, "mousedown"));
//		this.seleneseMethods.put("mouseMove", new MouseEvent(elementFinder,
//				javascriptLibrary, "mousemove"));
//		this.seleneseMethods.put("mouseMoveAt", new MouseEventAt(elementFinder,
//				javascriptLibrary, "mousemove"));
//		this.seleneseMethods.put("mouseUp", new MouseEvent(elementFinder,
//				javascriptLibrary, "mouseup"));
//		this.seleneseMethods.put("mouseUpAt", new MouseEventAt(elementFinder,
//				javascriptLibrary, "mouseup"));
//		this.seleneseMethods.put("open", new Open(this.baseUrl));
//		this.seleneseMethods.put("openWindow", new OpenWindow(this.baseUrl,
//				new GetEval(this.scriptMutator)));
//		this.seleneseMethods.put("refresh", new Refresh());
//		this.seleneseMethods.put("removeAllSelections",
//				new RemoveAllSelections(elementFinder));
//		this.seleneseMethods.put("removeSelection", new RemoveSelection(
//				javascriptLibrary, elementFinder));
//		this.seleneseMethods
//				.put("runScript", new RunScript(this.scriptMutator));
//		this.seleneseMethods.put("select", new SelectOption(alertOverride,
//				javascriptLibrary, elementFinder));
//		this.seleneseMethods.put("selectFrame", new SelectFrame(windows));
//		this.seleneseMethods.put("selectPopUp", new SelectPopUp(windows));
//		this.seleneseMethods.put("selectWindow", new SelectWindow(windows));
//		this.seleneseMethods.put("setBrowserLogLevel", new NoOp(null));
//		this.seleneseMethods.put("setContext", new NoOp(null));
//		this.seleneseMethods.put("setSpeed", new NoOp(null));
//		this.seleneseMethods.put("setTimeout", new SetTimeout(this.timer));
//		this.seleneseMethods.put("shiftKeyDown", new ShiftKeyDown(keyState));
//		this.seleneseMethods.put("shiftKeyUp", new ShiftKeyUp(keyState));
//		this.seleneseMethods.put("submit", new Submit(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("type", new Type(alertOverride,
//				javascriptLibrary, elementFinder, keyState));
//		this.seleneseMethods.put("typeKeys", new TypeKeys(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("uncheck", new Uncheck(alertOverride,
//				elementFinder));
//		this.seleneseMethods.put("useXpathLibrary", new UseXPathLibrary());
//		this.seleneseMethods.put("waitForCondition", new WaitForCondition(
//				this.scriptMutator));
//		this.seleneseMethods.put("waitForFrameToLoad", new NoOp(null));
//		this.seleneseMethods.put("waitForPageToLoad", new WaitForPageToLoad());
//		this.seleneseMethods.put("waitForPopUp", new WaitForPopup(windows));
//		this.seleneseMethods.put("windowFocus", new WindowFocus(
//				javascriptLibrary));
//		this.seleneseMethods.put("windowMaximize", new WindowMaximize(
//				javascriptLibrary));
//	}
//}
