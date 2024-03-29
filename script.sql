USE [ThueXe]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 3/13/2024 2:06:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[bookingID] [int] IDENTITY(1,1) NOT NULL,
	[userID] [int] NULL,
	[vehicleID] [int] NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[status] [int] NULL,
	[amount] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[bookingID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 3/13/2024 2:06:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[paymentID] [int] IDENTITY(1,1) NOT NULL,
	[bookingID] [int] NULL,
	[payment_method] [varchar](50) NOT NULL,
	[amount] [decimal](10, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[paymentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status]    Script Date: 3/13/2024 2:06:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 3/13/2024 2:06:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[userID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[address] [varchar](255) NULL,
	[phone] [varchar](20) NULL,
	[role] [varchar](50) NOT NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 3/13/2024 2:06:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[vehicleID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[image] [nvarchar](2000) NULL,
	[description] [text] NULL,
	[price] [decimal](10, 2) NOT NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK__Vehicle__5B9D25D2460FCD2C] PRIMARY KEY CLUSTERED 
(
	[vehicleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Booking] ON 

INSERT [dbo].[Booking] ([bookingID], [userID], [vehicleID], [start_date], [end_date], [status], [amount]) VALUES (3, 1, 1, CAST(N'2024-03-15' AS Date), CAST(N'2024-03-20' AS Date), 1, CAST(150.00 AS Decimal(10, 2)))
INSERT [dbo].[Booking] ([bookingID], [userID], [vehicleID], [start_date], [end_date], [status], [amount]) VALUES (4, 1, 1, CAST(N'2024-03-15' AS Date), CAST(N'2024-03-20' AS Date), 1, CAST(150.00 AS Decimal(10, 2)))
INSERT [dbo].[Booking] ([bookingID], [userID], [vehicleID], [start_date], [end_date], [status], [amount]) VALUES (7, 3, 2, CAST(N'2024-03-13' AS Date), CAST(N'2024-03-21' AS Date), 7, CAST(800.00 AS Decimal(10, 2)))
INSERT [dbo].[Booking] ([bookingID], [userID], [vehicleID], [start_date], [end_date], [status], [amount]) VALUES (8, 3, 1, CAST(N'2024-03-13' AS Date), CAST(N'2024-03-15' AS Date), 5, CAST(200.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[Booking] OFF
GO
SET IDENTITY_INSERT [dbo].[status] ON 

INSERT [dbo].[status] ([id], [name]) VALUES (1, N'Acitve')
INSERT [dbo].[status] ([id], [name]) VALUES (2, N'InActive')
INSERT [dbo].[status] ([id], [name]) VALUES (3, N'Processing')
INSERT [dbo].[status] ([id], [name]) VALUES (4, N'Pending')
INSERT [dbo].[status] ([id], [name]) VALUES (5, N'Paided')
INSERT [dbo].[status] ([id], [name]) VALUES (7, N'Cancel')
SET IDENTITY_INSERT [dbo].[status] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([userID], [username], [email], [password], [address], [phone], [role], [status]) VALUES (1, N'abc', N'www@gma.com', N'123', N'HN', N'0987654321', N'ADMIN', 1)
INSERT [dbo].[User] ([userID], [username], [email], [password], [address], [phone], [role], [status]) VALUES (3, N'abc2', N'qqqq@qưe.com', N'123', N'HN', N'0987654321', N'CUSTOMER', 1)
INSERT [dbo].[User] ([userID], [username], [email], [password], [address], [phone], [role], [status]) VALUES (4, N'Hung200110', N'eqwe@dqw.com', N'123456', N'HN', N'0987654321', N'CUSTOMER', 1)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
SET IDENTITY_INSERT [dbo].[Vehicle] ON 

INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (1, N'Vehicle 1012', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (2, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (3, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (4, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (5, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (6, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (7, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (8, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (9, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (10, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (12, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (13, N'Vehicle 1', N'https://th.bing.com/th/id/OIP.PE9VL5-d8WHCP7O0GFf1PQHaEM?w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', N'Description of Vehicle 1', CAST(100.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (14, N'Vision', N'', N'qưew', CAST(1000.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (15, N'Vision', N'', N'ưeqw', CAST(1232.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Vehicle] ([vehicleID], [name], [image], [description], [price], [status]) VALUES (16, N'Vision', N'https://www.msn.com/vi-vn/news/other/%C4%91%C6%B0a-v%E1%BB%A5-%C3%A1n-f88-v%C3%A0o-di%E1%BB%87n-ban-ch%E1%BB%89-%C4%91%E1%BA%A1o-ch%E1%BB%91ng-tham-nh%C5%A9ng-tp-hcm-theo-d%C3%B5i/ar-AA18H4aT?ocid=msedgntp&cvid=7e72c377cfc3458382aaef40e6f259aa&ei=8', N'ewq', CAST(12312.00 AS Decimal(10, 2)), 1)
SET IDENTITY_INSERT [dbo].[Vehicle] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__User__AB6E616437EE5BB5]    Script Date: 3/13/2024 2:06:44 AM ******/
ALTER TABLE [dbo].[User] ADD UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[User] ([userID])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK__Booking__vehicle__3D5E1FD2] FOREIGN KEY([vehicleID])
REFERENCES [dbo].[Vehicle] ([vehicleID])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK__Booking__vehicle__3D5E1FD2]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_status] FOREIGN KEY([status])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_status]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD FOREIGN KEY([bookingID])
REFERENCES [dbo].[Booking] ([bookingID])
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_status] FOREIGN KEY([status])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_status]
GO
ALTER TABLE [dbo].[Vehicle]  WITH CHECK ADD  CONSTRAINT [FK_Vehicle_status] FOREIGN KEY([status])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[Vehicle] CHECK CONSTRAINT [FK_Vehicle_status]
GO
