# Samsung Hidden Band Selection Launcher

This is a minimal Android app designed to open Samsung's hidden **Network Band Selection** menu — typically accessible only through internal system menus.  
> 📱 Supports **Android 14+ (One UI 6+)** on **rooted Samsung devices**.

---

## ⚙️ Requirements

- Samsung device running **Android 14 or above**
- **One UI 6 and One UI 7**
- **Root access** via [Magisk](https://topjohnwu.github.io/Magisk/) or [KernelSU](https://kernelsu.org/)
- Root access must be properly granted to the app

---

## 🚀 Features

- 📶 Opens **Samsung’s internal band selection activity**
- ⚡ One-tap launch, no need for manual `adb shell` commands
- 🔗 Includes a **shortcut creator** to pin the feature directly to your home screen
- 💡 Clean UI built using **Jetpack Compose**

---

## 🛠️ Installation & Usage

1. [Download the APK](https://github.com/kushagrasinghx/samsung-band-selection/releases) or build from source.
2. Install it on your **rooted Samsung device**.
3. Open the app.
4. When prompted, **grant superuser/root permission** via Magisk or KernelSU.
5. Tap `Open Hidden Settings` — the internal Samsung band selector will launch.

> 🧷 You can also create a homescreen shortcut using the "Create Shortcut" button for quick access in the future.

---

## 🔐 Root Methods Supported

- ✅ Magisk
- ✅ KernelSU

Root permission is required to execute the `am start` shell command with elevated privileges.

---

## 🧪 Disclaimer

This project is intended for **educational and personal use** only.  
Use at your own risk. Samsung may restrict or block access to internal components in future One UI versions.
