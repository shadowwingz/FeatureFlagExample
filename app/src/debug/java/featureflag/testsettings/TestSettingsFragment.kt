package com.jeroenmols.featureflag.testsettings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeroenmols.featureflag.example.databinding.FragmentTestsettingsBinding

class TestSettingsFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentTestsettingsBinding

    interface TestSettingsListener {
        fun onFeatureToggleClicked()
        fun onTestSettingClicked()
    }

    var testSettingListener: TestSettingsListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTestsettingsBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textviewTestsettingsFeaturetoggle.setOnClickListener { testSettingListener?.onFeatureToggleClicked() }
        binding.formattextviewTestsettingsTestsetting.setOnClickListener { testSettingListener?.onTestSettingClicked() }
    }

    override fun onResume() {
        super.onResume()
        activity?.title = "Test Settings"
    }
}