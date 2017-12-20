# Acrolinx Sidebar Java SDK

Acrolinx Sidebar Java SDK

This SDK contains code to build integration for Java FX, Swing or SWT based clients.

## The Acrolinx Sidebar

To use the Acrolinx Sidebar you need to have an Acrolinx Server set up.
The Acrolinx Sidebar comes in two flavours.

There is a publicly available Acrolinx Sidebar which will enable you to always use the newest
version of the Acrolinx Sidebar.
To use it you need an Acrolinx Server running via https and with CORS enabled.
Check the [Acrolinx Support](https://support.acrolinx.com/hc/en-us/articles/203851132-Setting-up-the-Acrolinx-Sidebar#Enable_Cross_Origin_Resource_Sharing_CORS_on_your_Core_Server_)
for more information on how to enable CORS on your Acrolinx Server.

Acrolinx Server 4.7 and later come with the Acrolinx Sidebar installed.
The Acrolinx Sidebar is then available under
`http(s)://<AcrolinxServerHostName>:port/sidebar/v14/index.html`.

For more information on Acrolinx check [www.acrolinx.com](https://www.acrolinx.com).

[Back to top](#acrolinx-java-sidebar-demo)

## Prerequisites

Please contact Acrolinx SDK support (sdk-support@acrolinx.com) for consulting and getting your integration certified.

Before you start developing your own integration, you might benefit from looking into the
[demo project for java based acrolinx integrations on GitHub](https://github.com/acrolinx/acrolinx-sidebar-demo-java).

## How to build your own integration

This Java SDK provides you ready build UI-Elements to display the Acrolinx Sidebar.
It contains sidebar interfaces for JFX, Swing and SWT based Java clients.
In addition the Acrolinx Start Page is included.

![Java SDK parts overview](/img/SketchJavaSDKComponents.png)

You will need to provide a mechanism, that allows the Acrolinx Sidebar to retrieve the text to be checked and to select
and replace specific parts of the text in the editor.

Before you start check the [sidebar demo for java on GitHub](https://github.com/acrolinx/acrolinx-sidebar-demo-java).

Check the [API Documentation](https://cdn.rawgit.com/acrolinx/sidebar-sdk-java/v1.0.2/docs/index.html).

The sidebar sdk is available on [Maven Central](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.acrolinx.client%22%20a%3A%22sidebar-sdk%22%20).

Please make yourself also familiar with the [acrolinx coding guidance](https://github.com/acrolinx/acrolinx-coding-guidance).

To build your own integration with an JFX, Swing or SWT based editor, you'll need to implement the `AcrolinxIntegration
Interface` and the `InputAdapterInterface`. This will enable the Acrolinx Sidebar to interact with your editor.

![Acrolinx Integration interacting with Acrolinx Sidebar and Acrolinx Server](/img/ArchitectureInterfaces.png)

When implementing `AcrolinxIntegrationInterface` make sure to make yourself familiar with `AcrolinxSidebarInitParameterBuilder`
to initialize the Acrolinx Sidebar according to your needs.

### Logging

On start of the integration call:

```
LoggingUtils.setupLogging("AcrolinxDemoClientJFX");
```

This will setup the logging according to the [acrolinx coding guidance](https://github.com/acrolinx/acrolinx-coding-guidance/blob/master/topics/logging.md)

### Lookup

The text in the editor might have been changed after it has been checked. Therefore the ranges for selection and replacing
as given by the sidebar could appear to not be correct. One approach to recalculate those offsets is implemented within the JAVA SDK,
which uses the diff-match-patch library.

Refer to class ``LookupRangesDiff``.

More information about how to implement a good lookup algorithm can be found in [acrolinx coding guidance](https://github.com/acrolinx/acrolinx-coding-guidance/blob/master/topics/text-lookup.md).


### Local Storage

The Acrolinx sidebar by default stores information in the local storage of browser that it is running in.
Some embedded browsers might not support local storage. Therefore you can implement the `AcrolinxStorage` interface.

## Enable CORS

If you want to use an Acrolinx Sidebar with an Acrolinx Server that run on different domains, you will have to enable
[CORS](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing). That can be done by setting the following System
property in your Java Code:

	System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

Or you can set the following VM Option when running Java:

	-Dsun.net.http.allowRestrictedHeaders=true

Also you'll need have CORS enabled on your Acrolinx Server.
For help check the Acrolinx Support on [how to enable CORS](https://support.acrolinx.com/hc/en-us/articles/203851132#task_izv_qn4_fv).

## Server Dependency

To use the Acrolinx Sidebar, you need to connect to an Acrolinx server. If you've already received your Acrolinx server address,
you’re good to go. If your company has installed an Acrolinx server, but you don't have an address yet, ask your server administrator first.

## License

Copyright 2016-2017 Acrolinx GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

For more information visit: http://www.acrolinx.com
