import 'package:finbro/ui/auth/login_screen.dart';
import 'package:finbro/ui/websocket_example.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
        debugShowCheckedModeBanner: false,
        home: LoginScreen());
  }
}
